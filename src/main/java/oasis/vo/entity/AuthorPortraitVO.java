package oasis.vo.entity;

import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/30 13:59
 * @description 作者画像 VO 类
 */
public class AuthorPortraitVO {

    /**
     * 作者姓名
     */
    private String name;

    /**
     * 作者H-Index
     */
    private Integer hindex;

    /**
     * 当前研究方向
     */
    private List<String> keywords;

    /**
     * 所在机构
     */
    private List<String> affiliations;

    /**
     * ASE和ICSE发表的论文数量
     */
    private PublicationNum publicationNum;

    /**
     * 文章引用数量
     */
    private Integer reference;

    /**
     * 作者活跃度
     */
    private Integer activation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHindex() {
        return hindex;
    }

    public void setHindex(Integer hindex) {
        this.hindex = hindex;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(List<String> affiliations) {
        this.affiliations = affiliations;
    }

    public PublicationNum getPublicationNum() {
        return publicationNum;
    }

    public void setPublicationNum(PublicationNum publicationNum) {
        this.publicationNum = publicationNum;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getActivation() {
        return activation;
    }

    public void setActivation(Integer activation) {
        this.activation = activation;
    }

    public AuthorPortraitVO() {
    }

    public AuthorPortraitVO(String name, Integer hindex, List<String> keywords, List<String> affiliations, Integer aseNum, Integer icseNum, Integer reference, Integer activation) {
        this.name = name;
        this.hindex = hindex;
        this.keywords = keywords;
        this.affiliations = affiliations;
        PublicationNum publication = new PublicationNum();
        publication.aseNum = aseNum;
        publication.icseNum = icseNum;
        this.publicationNum = publication;
        this.reference = reference;
        this.activation = activation;
    }

    /**
     * ASE 和 ICSE 发表的论文数量类
     */
    private static class PublicationNum {

        /**
         * ASE 发表的论文数量
         */
        private Integer aseNum;

        /**
         * ICSE 发表的论文数量
         */
        private Integer icseNum;

        public Integer getAseNum() {
            return aseNum;
        }

        public void setAseNum(Integer aseNum) {
            this.aseNum = aseNum;
        }

        public Integer getIcseNum() {
            return icseNum;
        }

        public void setIcseNum(Integer icseNum) {
            this.icseNum = icseNum;
        }

    }

}
