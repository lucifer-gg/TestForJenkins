package com.example.oasis.blImpl.DataChange;
import com.example.oasis.data.DataChange.DataChangeMapper;
import com.example.oasis.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.example.oasis.bl.DataChange.DataChangeService;
@Service
public class DataChange implements DataChangeService {
    @Autowired
    private DataChangeMapper dataChangeMapper;
    public void authorDomainChange(){
        System.out.println("authorDomainChange start");
        List<AuthorChangeOne> as=dataChangeMapper.getAuthor();
        AuthorDomain ad=new AuthorDomain();
        System.out.println(as.size());
        int length=as.size();
        for(int i=0;i<length;i++) {
            ad.setAuthor(as.get(i).getAuthor().trim());
            ad.setAuthorId(as.get(i).getAuthorId());
            ad.setOrgan(as.get(i).getOrgan().trim());
            List<String> domain =split(as.get(i).getDomain());
            for(int j=0;j<domain.size();j++){
                ad.setDomain(domain.get(j));
                dataChangeMapper.insertAuthorDomain(ad);


            }
        }
        System.out.println("authorDomainChange finish");
    }

    public void authorSpotChange(){
        System.out.println("start");
    }

    public void paperInfChange(){
        System.out.println("paperInfChange start");
        List<PaperChange> pc=dataChangeMapper.getPaperInf();
        System.out.println(pc.size());
        PaperInf pi=new PaperInf();
        int length=pc.size();
        for(int i=0;i<length;i++){
            pi.setAbstracts(pc.get(i).getAbstracts());
            pi.setAuthor(pc.get(i).getAuthor().trim());
            pi.setAuthorId(pc.get(i).getAuthorId());
            pi.setDoi(pc.get(i).getDoi());
            pi.setPaperId(pc.get(i).getPaperId());
            pi.setPdfLink(pc.get(i).getPdfLink());
            pi.setPublishTitle(pc.get(i).getPublishTitle());
            pi.setTime(pc.get(i).getTime());
            pi.setTitle(pc.get(i).getTitle());
            pi.setRedNum(pc.get(i).getCount1()+pc.get(i).getCount2());
            dataChangeMapper.insertPaperInf(pi);
        }
        System.out.println("paperInfChange finish");}

    public void paperSpotChange(){
        System.out.println("paperSpotChange start");
        List<AuthorChangeTwo> at=dataChangeMapper.getPaperSpot();
        System.out.println(at.size());
        PaperSpot ps=new PaperSpot();
        int length=at.size();
        for(int i=0;i<length;i++){
            ps.setAbstracts(at.get(i).getAbstract());
            ps.setAuthorId(at.get(i).getAuthorId());
            ps.setPaperId(at.get(i).getPaperId());
            ps.setTime(at.get(i).getTime());
            ps.setPdfLink(at.get(i).getPdfLink());
            ps.setTitle(at.get(i).getTitle());
            List<String> spot =split(at.get(i).getSpot());
            for(int j=0;j<spot.size();j++){
                ps.setSpot(spot.get(j));
                dataChangeMapper.insertPaperSpot(ps);

            }

        }
        System.out.println("paperSpotChange finish");
    }
    public void AuthorHotChange(){
        System.out.println("AuthorHot start");
        List<AuthorDomain> ad=dataChangeMapper.getAllAuthorDomain();
        int length=ad.size();
        for(int i=0;i<length;i++){
            float d=1;
            AuthorHot ah=new AuthorHot();
            ah.setAuthor(ad.get(i).getAuthor());
            ah.setAuthorId(ad.get(i).getAuthorId());
            ah.setDomain(ad.get(i).getDomain());
            float allPapers=dataChangeMapper.getPapers(ad.get(i).getDomain());
            float authorPapers=dataChangeMapper.getPaperNum(ad.get(i).getAuthorId(),ad.get(i).getDomain());
            d=(authorPapers*authorPapers+authorPapers)/(allPapers);
            ah.setHotNum(d*10);
            dataChangeMapper.insertHot(ah);

        }
        System.out.println("AuthorHot finish");
    }
    public void PaperHotChange(){
        System.out.println("PaperHotChange start");
        List<paperHotInf> phi=dataChangeMapper.getPaperHotInf();
        int length=phi.size();
        for(int i=0;i<length;i++){
            double result=0;
            result=(1+Math.log(phi.get(i).getCounts()+1)/20)*1000+500*(TimeChange(phi.get(i).getTime()));
            result+=dataChangeMapper.getAuthorNum(phi.get(i).getPaperId())*10;
            paperHot ph=new paperHot();
            ph.setPaperId(phi.get(i).getPaperId());
            ph.setHotNum(result);
            System.out.println(result);
            dataChangeMapper.insertPaperHot(ph);
        }
        System.out.println("PaperHotChange finish");
    }
    public float TimeChange(int time){
        float result=1;
        if(time>=2016){
            result+=((time-2016)*0.08);
        }
        else{
            result-=((2016-time)*0.04);
        }
        return result;
    }
    public  void collaborateChange(){
        System.out.println("CollaborateChange start");
        List<PAForm> pas=dataChangeMapper.findAuthorIds();
        int length=pas.size();
        System.out.println(length);
        int paperid=pas.get(0).getPaperId();
        List<Integer> same_authors=new ArrayList<>();
        for(int i=0;i<pas.size();i++){
            if(paperid==pas.get(i).getPaperId()){
                same_authors.add(pas.get(i).getAuthorId());
            }
            else{
                save(same_authors);
                same_authors=new ArrayList<>();
                same_authors.add(pas.get(i).getAuthorId());
                paperid=pas.get(i).getPaperId();
            }

        }
        save(same_authors);
        System.out.println("CollaborateChange finish");
    }
    public  void save(List<Integer> sa){
        int length=sa.size();
        for(int i=0;i<length;i++)
            for(int j=i+1;j<length;j++){
                int one=dataChangeMapper.findCollaboration(sa.get(i),sa.get(j));
                int two=dataChangeMapper.findCollaboration(sa.get(j),sa.get(i));
                if(one>0){
                    dataChangeMapper.updateCollaboration(sa.get(i),sa.get(j));

                }
                else if(two>0){
                    dataChangeMapper.updateCollaboration(sa.get(j),sa.get(i));

                }
                else{
                    CollaborateChange cc=dataChangeMapper.getCollaborateInf(sa.get(i),sa.get(j));
                    cc.setTimes(1);
                    cc.setAuthor1(cc.getAuthor1().trim());
                    cc.setAuthor2(cc.getAuthor2().trim());
                    cc.setOrgan1(cc.getOrgan1().trim());
                    cc.setOrgan2(cc.getOrgan2().trim());
                    //System.out.println(sa.get(i)+" "+sa.get(j));
                    dataChangeMapper.insertCollaborateInf(cc);

                }

            }

    }
    public List<String> split(String d){
        List<String> domain =new ArrayList<>();
        if(d.contains("|")){
            String[] ds=d.split("\\|");
            for(int i=0;i<ds.length;i++){
                domain.add(ds[i].trim());

            }
        }
        else if(d.contains(";")){
            String[] ds=d.split(";");
            for(int i=0;i<ds.length;i++){
                domain.add(ds[i].trim());

            }
        }
        else
            domain.add(d.trim());
        return  domain;
    }

}

