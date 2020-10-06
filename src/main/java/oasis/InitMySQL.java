package oasis;

/**
 * @auhor cmw
 * 本文件用于读取csv文件初始化数据库
 */

import com.csvreader.CsvReader;
import com.google.common.base.Joiner;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.*;


public class InitMySQL {

    public ArrayList<Integer> removeDuplicate(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }

//返回结果

        return list;
    }//用于数组去重

    //初始化数据库连接
    public Connection initial_con(String DB_URL, String USER, String PASS) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 以下写入方法的总体思路均为
     * 读取csv文件相关列信息并进行清洗处理
     * 判断数据库中是否存在相关信息
     * 不存在则插入
     * 返回id用于后续对照表的写入
     */

    //写入作者和机构信息
    public ArrayList<Integer> insertAffiliAndAuthor(CsvReader cr, Connection conn, ArrayList<Integer> authorIdList, ArrayList<Integer> affilicationIdList) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        int affiliationId;
        try {
            String[] affilicationList = cr.get(2).split(";");
            String[] authorList = cr.get(1).split(";");


            //插入机构和作者信息
            for (int i = 0; i < affilicationList.length; i++) {
                if (affilicationList[i] != "" && i < authorList.length) {
                    stmt = conn.createStatement();
                    sql = "select affiliation_id from affiliation_info where affiliation_name=\"" + affilicationList[i].trim() + "\"";
                    rs = stmt.executeQuery(sql);
                    if (rs.next() == false) {
                        //如果不存在机构信息，则插入
                        stmt = conn.createStatement();
                        sql = "insert into affiliation_info (affiliation_name) values(\"" + affilicationList[i].trim() + "\")";
                        stmt.execute(sql);
                        //获取机构id
                        stmt = conn.createStatement();
                        sql = "select affiliation_id from affiliation_info where affiliation_name=\"" + affilicationList[i].trim() + "\"";
                        rs = stmt.executeQuery(sql);
                        rs.next();
                    }
                    affiliationId = rs.getInt("affiliation_id");
                    affilicationIdList.add(affiliationId);


                    //不存在作者信息则插入
                    stmt = conn.createStatement();
                    sql = "select author_id from author_info where author_name=\"" + authorList[i].trim() + "\"" + "and affiliation_id=" + affiliationId;
                    rs = stmt.executeQuery(sql);
                    if (rs.next() == false) {
                        stmt = conn.createStatement();
                        sql = "insert into author_info (author_name,affiliation_id) values (\"" + authorList[i].trim() + "\"," + affiliationId + ")";
                        stmt.execute(sql);
                        stmt = conn.createStatement();
                        sql = "select author_id from author_info where author_name=\"" + authorList[i].trim() + "\"" + "and affiliation_id=" + affiliationId;
                        rs = stmt.executeQuery(sql);
                        rs.next();

                    }

                    authorIdList.add(rs.getInt("author_id"));

                }
            }

            affilicationIdList = removeDuplicate(affilicationIdList);
            authorIdList = removeDuplicate(authorIdList);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorIdList;

    }

    //写入关键词信息
    public ArrayList<Integer> insertKeyword(CsvReader cr, Connection conn, ArrayList<Integer> keyWordIdList) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        double randd = 0.0;
        double randi = 0;
        try {
            keyWordIdList = new ArrayList<>();
            String[] keywordsList = cr.get(16).split(";");
            for (int i = 0; i < keywordsList.length; i++) {
                randd = Math.random();
                randi = (int) (randd * 10000);
                if (keywordsList[i] != "") {
                    stmt = conn.createStatement();
                    sql = "select * from keyword_info where keyword=\"" + keywordsList[i].trim() + "\"";
                    rs = stmt.executeQuery(sql);
                    if (rs.next() == false) {
                        stmt = conn.createStatement();
                        sql = "insert into keyword_info (keyword,keyword_search_count) values(\"" + keywordsList[i].trim() + "\"," + randi + ")";
                        stmt.execute(sql);
                        stmt = conn.createStatement();
                        sql = "select keyword_id from keyword_info where keyword=\"" + keywordsList[i].trim() + "\"";
                        rs = stmt.executeQuery(sql);
                        rs.next();
                    }
                    keyWordIdList.add(rs.getInt("keyword_id"));


                }
            }

            keyWordIdList = removeDuplicate(keyWordIdList);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return keyWordIdList;
    }

    //写入会议信息
    public int insertPublication(CsvReader cr, Connection conn, String type) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        int publicationId = -1;
        try {
            String publicationTitle = cr.get(3).trim();
            String publicationYear = cr.get(5).trim();
            stmt = conn.createStatement();
            sql = "select publication_id from publication_info where publication_title=\"" + publicationTitle + "\" and publication_year=\"" + publicationYear + "\"";
            rs = stmt.executeQuery(sql);
            if (rs.next() == false) {
                //如果没有会议信息则插入
                stmt = conn.createStatement();
                sql = "insert into publication_info (publication_title, publication_year,publication_type) values(\"" + publicationTitle + "\",\"" + publicationYear + "\",\"" + type + "\")";
                stmt.execute(sql);
                stmt = conn.createStatement();
                sql = "select publication_id from publication_info where publication_title=\"" + publicationTitle + "\" and publication_year=\"" + publicationYear + "\"";
                rs = stmt.executeQuery(sql);
                rs.next();
            }
            publicationId = rs.getInt("publication_id");
            stmt.close();
            rs.close();
        } catch (Exception e) {

        }
        return publicationId;
    }

    //写入文章信息
    public int insertAtricle(CsvReader cr, Connection conn, int publicationId) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        int articleId = 0;
        try {
            String docTitle = cr.get(0).trim().replace("\"", "'");
            int startPage = 0;
            if (cr.get(8).trim().length() != 0) {
                startPage = Integer.parseInt(cr.get(8).trim());
            }
            int endPage = 0;
            if (cr.get(9).trim().length() != 0) {
                endPage = Integer.parseInt(cr.get(9).trim());
            }
            String docAbstract = cr.get(10).trim().replace("\"", "'");
            String doi = cr.get(13).trim();
            String pdfLink = cr.get(15).trim();
            int referenceCount = 0;
            if (cr.get(22).trim().length() != 0) {
                referenceCount = Integer.parseInt(cr.get(22).trim());
            }
            int citation = 0;
            if (cr.get(21).trim().length() != 0) {
                citation = Integer.parseInt(cr.get(21).trim());
            }
            String publisher = cr.get(27).trim();
            String docIdentifier = cr.get(28).trim();

            stmt = conn.createStatement();
            sql = "select doc_id from article_info where doc_title=\"" + docTitle + "\" and publication_id=" + publicationId;
            rs = stmt.executeQuery(sql);


            if (rs.next() == false) {
                //如果不存在论文信息则插入
                stmt = conn.createStatement();
                sql = "select publication_year from publication_info where publication_id=" + publicationId;
                rs = stmt.executeQuery(sql);
                rs.next();
                int pb_year = rs.getInt("publication_year");

                stmt = conn.createStatement();
                sql = "insert into article_info (doc_title, publication_id, startpage, endpage, doc_abstract, pdf_link, doi, " +
                        "reference_count, citation, publisher, doc_identifier,search_count,publish_year) values (\"" + docTitle + "\"," + publicationId + "," + startPage + "," + endPage + ",\"" + docAbstract + "\",\"" + pdfLink +
                        "\",\"" + doi + "\"," + referenceCount + "," + citation + ",\"" + publisher + "\",\"" + docIdentifier + "\"," + 0 + ",\"" + pb_year + "\")";
                stmt.execute(sql);
                //获取文章id
                stmt = conn.createStatement();
                sql = "select doc_id from article_info where doc_title=\"" + docTitle + "\"";
                rs = stmt.executeQuery(sql);
                rs.next();
            }
            articleId = rs.getInt("doc_id");
            stmt.close();
            rs.close();
        } catch (Exception e) {

        }
        return articleId;
    }

    //初始化作者的hindex指标
    public void initAuthorHindex(Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;

        try {
            stmt = con.createStatement();
            sql = "select  author_id from  author_info";
            rs = stmt.executeQuery(sql);
            int authorId = 0;
            int authorHindex = 0;
            while (rs.next()) {
                authorId = rs.getInt("author_id");
                authorHindex = calAuthorHIndex(authorId, con);

                stmt2 = con.createStatement();
                sql2 = "update author_info set author_hindex=" + authorHindex + " where author_id=" + authorId;
                stmt2.execute(sql2);
            }

            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化机构的hindex指标
    public void initAffiliationHindex(Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;

        try {
            stmt = con.createStatement();
            sql = "select  affiliation_id from  affiliation_info";
            rs = stmt.executeQuery(sql);
            int affiliationId = 0;
            int affiliationHindex = 0;
            while (rs.next()) {
                affiliationId = rs.getInt("affiliation_id");
                affiliationHindex = calAffiliationHIndex(affiliationId, con);

                stmt2 = con.createStatement();
                sql2 = "update affiliation_info set affiliation_hindex=" + affiliationHindex + " where affiliation_id=" + affiliationId;
                stmt2.execute(sql2);
            }

            stmt.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化ASE的hindex指标
    public void initAseHindex(Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;


        try {

            stmt = con.createStatement();
            sql = "select publication_year,publication_id from publication_info where publication_type=\"ase\"";
            rs = stmt.executeQuery(sql);
            int pbYear = 0;
            int pbId = 0;
            int pbHindex = 0;
            while (rs.next()) {
                pbId = rs.getInt("publication_id");
                pbYear = Integer.parseInt(rs.getString("publication_year"));
                pbHindex = calAseHindex(pbYear, con);

                stmt2 = con.createStatement();
                sql2 = "update publication_info set publication_hindex=" + pbHindex + " where publication_id=" + pbId;
                stmt2.execute(sql2);


            }


            stmt.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //初始化Icse的hindex指标
    public void initIcseHindex(Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;


        try {
            stmt = con.createStatement();
            sql = "select publication_year,publication_id from publication_info where publication_type=\"icse\"";
            rs = stmt.executeQuery(sql);
            int pbYear = 0;
            int pbId = 0;
            int pbHindex = 0;
            while (rs.next()) {
                pbId = rs.getInt("publication_id");
                pbYear = Integer.parseInt(rs.getString("publication_year"));
                pbHindex = calIcseHindex(pbYear, con);

                stmt2 = con.createStatement();
                sql2 = "update publication_info set publication_hindex=" + pbHindex + " where publication_id=" + pbId;
                stmt2.execute(sql2);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //初始化作者活跃度
    public void initAuthorActivation(Connection con) {

        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;
        try {
            stmt = con.createStatement();
            sql = "select author_id from author_info";
            rs = stmt.executeQuery(sql);
            int authorId = 0;
            int authorAct = 0;
            while (rs.next()) {
                authorId = rs.getInt("author_id");
                authorAct = calAuthorActivation(authorId, con);
                stmt2 = con.createStatement();
                sql2 = "update author_info set author_activation=" + authorAct + " where author_id=" + authorId;
                stmt2.execute(sql2);
            }


            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //初始化机构活跃度
    public void initAffiliationActivation(Connection con) {

        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;
        try {
            stmt = con.createStatement();
            sql = "select affiliation_id from affiliation_info";
            rs = stmt.executeQuery(sql);
            int affiliationId = 0;
            int affiliationAct = 0;
            while (rs.next()) {
                affiliationId = rs.getInt("affiliation_id");
                affiliationAct = calAffiliationActivation(affiliationId, con);
                stmt2 = con.createStatement();
                sql2 = "update affiliation_info set affiliation_activation=" + affiliationAct + " where affiliation_id=" + affiliationId;
                stmt2.execute(sql2);
            }


            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //初始化研究方向活跃度
    public void initKeyWordActivation(Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;
        int keyWordAct = 0;
        int keyWordId = 0;

        try {
            stmt = con.createStatement();
            sql = "select keyword_id from keyword_info";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                keyWordId = rs.getInt("keyword_id");
                keyWordAct = calKeyWordActivation(keyWordId, con);
                stmt2 = con.createStatement();
                sql2 = "update keyword_info set keyword_activation=" + keyWordAct + " where keyword_id=" + keyWordId;
                stmt2.execute(sql2);
            }


            stmt.close();
            rs.close();
        } catch (Exception e) {


        }


    }

    //初始化相关作者推荐
    public void initRelatedAuthors(Connection conn, String path) {
        try {
            Statement stmt = conn.createStatement();
            ClassPathResource fileResource = new ClassPathResource(path);
            File file = new File("a.txt");
            InitMySQL.inputStreamToFile(fileResource.getInputStream(), file);
            // 从文件加载数据
            DataModel model = new FileDataModel(file);
            // 指定用户相似度计算方法，这里采用皮尔森相关度
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            // 指定用户邻居数量，这里为3
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);

            List<Integer> authorIds = new ArrayList<>();

            String authorSql = "select distinct author_id from author_info";
            ResultSet authorSet = stmt.executeQuery(authorSql);
            while (authorSet.next()) {
                authorIds.add(authorSet.getInt("author_id"));
            }
            authorSet.close();

            // 得到所有用户的推荐结果
            for (Integer authorId : authorIds) {
                long[] neighbors = neighborhood.getUserNeighborhood(authorId);

                String strNeighbors = Arrays.toString(neighbors);
                strNeighbors = "'" + strNeighbors.replaceAll(", ", "*").replace("[", "").replace("]", "") + "'";
                String insertSql = "update author_info set related_authors = " + strNeighbors + " where author_id = " + authorId;
                stmt.execute(insertSql);
            }

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //计算作者活跃度
    public int calAuthorActivation(int authorId, Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;
        ResultSet rs2 = null;

        int authorAct = 0;
        int docId = 0;

        try {
            stmt = con.createStatement();
            sql = "select doc_id from article_to_author where author_id=" + authorId;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                docId = rs.getInt("doc_id");

                stmt2 = con.createStatement();
                sql2 = "select publish_year,reference_count,citation from article_info where doc_id=" + docId;
                rs2 = stmt2.executeQuery(sql2);
                while (rs2.next()) {
                    int year = Integer.parseInt(rs2.getString("publish_year"));
                    int rfc = rs2.getInt("reference_count");
                    int citation = rs2.getInt("citation");
                    authorAct += 5 * (10 - (2021 - year)) + rfc + calAuthorHIndex(authorId, con) + citation;
                }
            }
            stmt.close();
            rs.close();

            return authorAct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //计算机构活跃度
    public int calAffiliationActivation(int affiliationId, Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;


        int affiliationAct = 0;


        try {
            stmt = con.createStatement();
            sql = "select author_activation from author_info where affiliation_id=" + affiliationId;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                affiliationAct += rs.getInt("author_activation");
            }

            stmt = con.createStatement();
            sql = "select affiliation_hindex from affiliation_info where affiliation_id=" + affiliationId;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                affiliationAct += rs.getInt("affiliation_hindex") * 10;
            }


            stmt.close();
            rs.close();

            return affiliationAct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //计算研究方向活跃度
    public int calKeyWordActivation(int keywordId, Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;
        ResultSet rs2 = null;


        try {
            stmt = con.createStatement();
            sql = "select doc_id from article_to_keyword where keyword_id=" + keywordId;
            rs = stmt.executeQuery(sql);
            int docId = 0;
            int keyWordActivation = 0;
            while (rs.next()) {
                docId = rs.getInt("doc_id");
                stmt2 = con.createStatement();
                sql2 = "select publish_year,reference_count from  article_info where doc_id=" + docId;
                rs2 = stmt2.executeQuery(sql2);

                while (rs2.next()) {
                    int year = Integer.parseInt(rs2.getString("publish_year"));
                    int ref = rs2.getInt("reference_count");
                    keyWordActivation += (2021 - year) * 20 + ref + calAvgAuthorActAboutArticle(docId, con);
                }
            }
            stmt.close();
            rs.close();

            return keyWordActivation;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return 0;
    }

    //计算关于谋翩翩文章的作者平均活跃度
    public int calAvgAuthorActAboutArticle(int articleId, Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;
        ResultSet rs2 = null;

        try {
            stmt = con.createStatement();
            sql = "select author_id from article_to_author where doc_id=" + articleId;
            rs = stmt.executeQuery(sql);
            int sumAct = 0;
            int count = 0;
            while (rs.next()) {
                int authorId = rs.getInt("author_id");
                stmt2 = con.createStatement();
                sql2 = "select author_activation from author_info where author_id=" + authorId;
                rs2 = stmt2.executeQuery(sql2);
                if (rs2.next()) {
                    sumAct += rs2.getInt("author_activation");
                    count++;
                }
            }

            stmt.close();
            rs.close();

            return sumAct / count;


        } catch (Exception e) {
            e.printStackTrace();
        }


        return 0;
    }


    //计算ASE总Hidex
    public int calTotalAseHindex(Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;
        ResultSet rs2 = null;
        ArrayList<Integer> referenceList = new ArrayList<>();
        try {
            stmt = con.createStatement();
            sql = "select publication_id from publication_info where publication_type=\"ase\"";
            rs = stmt.executeQuery(sql);
            int pbId = 0;
            while (rs.next()) {
                pbId = rs.getInt("publication_id");
                stmt2 = con.createStatement();
                sql2 = "select reference_count from article_info where publication_id=" + pbId;
                rs2 = stmt2.executeQuery(sql2);
                while (rs2.next()) {
                    referenceList.add(rs2.getInt("reference_count"));
                }

            }
            stmt.close();
            rs.close();

            return hIndex(referenceList);


        } catch (Exception e) {

        }

        return 0;
    }//59

    //计算ICSE总Hindex
    public int calTotalIcseHindex(Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = null;
        ResultSet rs2 = null;
        ArrayList<Integer> referenceList = new ArrayList<>();
        try {
            stmt = con.createStatement();
            sql = "select publication_id from publication_info where publication_type=\"icse\"";
            rs = stmt.executeQuery(sql);
            int pbId = 0;
            while (rs.next()) {
                pbId = rs.getInt("publication_id");
                stmt2 = con.createStatement();
                sql2 = "select reference_count from article_info where publication_id=" + pbId;
                rs2 = stmt2.executeQuery(sql2);
                while (rs2.next()) {
                    referenceList.add(rs2.getInt("reference_count"));
                }

            }
            stmt.close();
            rs.close();

            return hIndex(referenceList);


        } catch (Exception e) {

        }

        return 0;
    }//65


    //用于计算Ase某年会议的Hindex
    public int calAseHindex(int year, Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        ArrayList<Integer> referenceList = new ArrayList<>();
        try {
            int pbId = 0;
            stmt = con.createStatement();
            sql = "select publication_id from publication_info where publication_year=\"" + year + "\" and publication_type=\"ase\"";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                pbId = rs.getInt("publication_id");
            }
            stmt = con.createStatement();
            sql = "select reference_count from article_info where publication_id=" + pbId;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                referenceList.add(rs.getInt("reference_count"));
            }
            stmt.close();
            rs.close();
            return hIndex(referenceList);
        } catch (Exception e) {

        }

        return 0;
    }

    //用于计算Icse某年会议的Hindex
    public int calIcseHindex(int year, Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        ArrayList<Integer> referenceList = new ArrayList<>();


        try {
            int pbId = 0;
            stmt = con.createStatement();
            sql = "select publication_id from publication_info where publication_year=\"" + year + "\" and publication_type=\"icse\"";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                pbId = rs.getInt("publication_id");
            }
            stmt = con.createStatement();
            sql = "select reference_count from article_info where publication_id=" + pbId;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                referenceList.add(rs.getInt("reference_count"));
            }

            stmt.close();
            rs.close();


            return hIndex(referenceList);


        } catch (Exception e) {

        }


        return 0;
    }

    //用于计算作者的Hindex
    public int calAuthorHIndex(int authorId, Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        ArrayList<Integer> referenceList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            sql = "select doc_id from article_to_author where author_id=" + authorId;
            rs = stmt.executeQuery(sql);
            int docId;
            Statement stmt2 = null;
            String sql2 = "";
            ResultSet rs2 = null;
            while (rs.next() != false) {
                docId = rs.getInt("doc_id");
                stmt2 = con.createStatement();
                sql2 = "select reference_count from article_info where doc_id=" + docId;
                rs2 = stmt2.executeQuery(sql2);
                while (rs2.next()) {
                    referenceList.add(rs2.getInt("reference_count"));
                }
            }
            stmt.close();
            rs.close();
            return hIndex(referenceList);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return 0;


    }

    //用于计算某机构的hindex
    public int calAffiliationHIndex(int affiliationId, Connection con) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String sql2 = "";
        ResultSet rs2 = null;
        ArrayList<Integer> referenceList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            sql = "select doc_id from article_to_affiliation where affiliation_id=" + affiliationId;
            rs = stmt.executeQuery(sql);
            int docId;
            while (rs.next() != false) {
                docId = rs.getInt("doc_id");
                stmt2 = con.createStatement();
                sql2 = "select reference_count from article_info where doc_id=" + docId;
                rs2 = stmt2.executeQuery(sql2);
                while (rs2.next()) {
                    referenceList.add(rs2.getInt("reference_count"));
                }
            }
            stmt.close();
            rs.close();
            return hIndex(referenceList);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return 0;
    }


    //hindex计算算法
    public int hIndex(ArrayList<Integer> citations) {
        int n = citations.size();
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations.get(i) >= n) count[n]++; //统计引用数比总文章数还多的文章数目
            else count[citations.get(i)]++; //统计每个引用次数下有多少篇文章
        }
        if (count[n] >= n) return n; //如果每篇文章的引用数都比文章数多，那H指数最多也只能是文章数n
        for (int i = n - 1; i >= 0; i--) {
            count[i] += count[i + 1]; //不要忘了这里的i一直是引用次数，所以这一步在统计大于等于i的文章总数，即逐个累加大于等于i的计数
            if (count[i] >= i) return i; //一旦找到满足条件的引用次数，即返回
        }
        return 0;
    }

    //读取csv文件并初始化数据库
    public void readFromCsv(Connection conn, String path, String publicationType) {

        try {
            CsvReader cr = null;
            ClassPathResource classPathResource = new ClassPathResource(path);
            InputStream in = classPathResource.getInputStream();
            cr = new CsvReader(in, ',', Charset.forName("UTF-8"));
            ArrayList<Integer> authorIdList;
            ArrayList<Integer> keywordIdList;
            ArrayList<Integer> affiliationIdList;
            cr.readHeaders();


            Statement stmt = null;
            String sql = null;
            ResultSet rs = null;
            while (cr.readRecord()) {
                //不处理非论文项
                if (cr.get(1) == "") {
                    continue;
                }
                authorIdList = new ArrayList<>();
                keywordIdList = new ArrayList<>();
                affiliationIdList = new ArrayList<>();
                insertAffiliAndAuthor(cr, conn, authorIdList, affiliationIdList);
                keywordIdList = insertKeyword(cr, conn, keywordIdList);
                int pubId = insertPublication(cr, conn, publicationType);
                int articleId = insertAtricle(cr, conn, pubId);


                for (int i = 0; i < affiliationIdList.size(); i++) {
                    stmt = conn.createStatement();
                    sql = "select * from article_to_affiliation where doc_id=" + articleId + " and affiliation_id=" + affiliationIdList.get(i);
                    rs = stmt.executeQuery(sql);
                    if (rs.next() == false) {
                        stmt = conn.createStatement();
                        sql = "insert into article_to_affiliation (doc_id, affiliation_id) values (" + articleId + "," + affiliationIdList.get(i) + ")";
                        stmt.execute(sql);
                    }
                }

                for (int i = 0; i < authorIdList.size(); i++) {
                    stmt = conn.createStatement();
                    sql = "select * from article_to_author where doc_id=" + articleId + " and author_id=" + authorIdList.get(i);
                    rs = stmt.executeQuery(sql);
                    if (rs.next() == false) {
                        stmt = conn.createStatement();
                        sql = "insert into article_to_author (doc_id, author_id) values (" + articleId + "," + authorIdList.get(i) + ")";
                        stmt.execute(sql);
                    }
                }

                for (int i = 0; i < keywordIdList.size(); i++) {
                    stmt = conn.createStatement();
                    sql = "select * from article_to_keyword where doc_id=" + articleId + " and keyword_id=" + keywordIdList.get(i);
                    rs = stmt.executeQuery(sql);
                    if (rs.next() == false) {
                        stmt = conn.createStatement();
                        sql = "insert into article_to_keyword (doc_id, keyword_id) values (" + articleId + "," + keywordIdList.get(i) + ")";
                        stmt.execute(sql);
                    }
                }
            }

            in.close();
            cr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //训练kmeans模型用于相关作者推荐
    public void initDataModel(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            List<Model> dataList = new ArrayList<>();

            List<Integer> authorIds = new ArrayList<>();
            String authorSql = "select distinct author_id from author_info";
            ResultSet authorSet = stmt.executeQuery(authorSql);
            while (authorSet.next()) {
                authorIds.add(authorSet.getInt("author_id"));
            }
            authorSet.close();

            for (Integer curAuthorId : authorIds) {
                System.out.println("\nCurrent author: " + curAuthorId);

                Map<Integer, Integer> map = computAuthorRelation(curAuthorId, authorIds, conn);

                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    Model data = new Model(curAuthorId, entry.getKey(), entry.getValue());
                    System.out.println(data.toString());
                    dataList.add(data);
                }
            }

            stmt.close();

            writeCSV(dataList, "src/main/resources/datasource/model.csv");
            System.out.println("作者行为数据初始化完毕");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("作者行为数据初始化失败");
        }
    }

    //计算作者相关度
    public Map<Integer, Integer> computAuthorRelation(int authorId, List<Integer> authorIds, Connection conn) {
        Map<Integer, Integer> map = new HashMap<>();
        try {
            Statement stmt = conn.createStatement();

            List<Integer> curAuthorDocs = new ArrayList<>();
            String allDocsSql = "select distinct doc_id from article_to_author where author_id = " + authorId;
            ResultSet curAuthorDocSet = stmt.executeQuery(allDocsSql);
            while (curAuthorDocSet.next()) {
                curAuthorDocs.add(curAuthorDocSet.getInt("doc_id"));
            }
            curAuthorDocSet.close();

            List<Integer> curAuthorAffls = new ArrayList<>();
            String allAfflsSql = "select distinct affiliation_id from author_info where author_id = " + authorId;
            ResultSet curAuthorAfflSet = stmt.executeQuery(allAfflsSql);
            while (curAuthorAfflSet.next()) {
                curAuthorAffls.add(curAuthorAfflSet.getInt("affiliation_id"));
            }
            curAuthorAfflSet.close();

            List<Integer> curAuthorkeywords = new ArrayList<>();
            String allKeywordsSql = "select distinct keyword_id from article_to_keyword where doc_id in ( " + listToSqlList(curAuthorDocs) + " )";
            ResultSet curAuthorKeywordSet = stmt.executeQuery(allKeywordsSql);
            while (curAuthorKeywordSet.next()) {
                curAuthorkeywords.add(curAuthorKeywordSet.getInt("keyword_id"));
            }
            curAuthorKeywordSet.close();

            List<Integer> curAuthorPubs = new ArrayList<>();
            String allPubsSql = "select distinct publication_id from article_info where doc_id in ( " + listToSqlList(curAuthorDocs) + " )";
            ResultSet curAuthorPubSet = stmt.executeQuery(allPubsSql);
            while (curAuthorPubSet.next()) {
                curAuthorPubs.add(curAuthorPubSet.getInt("publication_id"));
            }
            curAuthorPubSet.close();

            int authorCount = authorIds.size();
            for (int i = 0; i < authorCount; i++) {
                Integer otsAuthorId = authorIds.get(i);
                if (authorId != otsAuthorId) {
                    int preference = 0;

                    if (curAuthorDocs.size() != 0) {
                        String ifCoopedSql = "select count(doc_id) as bool from article_to_author where doc_id in ( " + listToSqlList(curAuthorDocs) + " ) and author_id = " + otsAuthorId;
                        ResultSet ifCoopedSet = stmt.executeQuery(ifCoopedSql);
                        ifCoopedSet.next();
                        // 合作过一篇文章加10
                        if (ifCoopedSet.getBoolean("bool")) {
                            preference += 10;
                        }
                        ifCoopedSet.close();
                    }

                    if (curAuthorAffls.size() != 0) {
                        String isInSameAfflSql = "select count(author_id) as bool from author_info where affiliation_id in ( " + listToSqlList(curAuthorAffls) + " ) and author_id = " + otsAuthorId;
                        ResultSet isInSameAfflSet = stmt.executeQuery(isInSameAfflSql);
                        isInSameAfflSet.next();
                        // 工作在同一个机构加5
                        if (isInSameAfflSet.getBoolean("bool")) {
                            preference += 5;
                        }
                        isInSameAfflSet.close();
                    }

                    if (curAuthorkeywords.size() != 0) {
                        List<Integer> sameKeywordDocs = new ArrayList<>();
                        String sameKeywordDocSql = "select distinct doc_id from article_to_keyword where keyword_id in ( " + listToSqlList(curAuthorkeywords) + " )";
                        ResultSet sameKeywordDocSet = stmt.executeQuery(sameKeywordDocSql);
                        while (sameKeywordDocSet.next()) {
                            sameKeywordDocs.add(sameKeywordDocSet.getInt("doc_id"));
                        }
                        sameKeywordDocSet.close();

                        if (sameKeywordDocs.size() != 0) {
                            String ifSameKeywordSql = "select count(author_id) as bool from article_to_author where doc_id in ( " + listToSqlList(sameKeywordDocs) + " ) and author_id = " + otsAuthorId;
                            ResultSet ifSameKeywordSet = stmt.executeQuery(ifSameKeywordSql);
                            ifSameKeywordSet.next();
                            // 文章有相同关键词加3
                            if (ifSameKeywordSet.getBoolean("bool")) {
                                preference += 3;
                            }
                            ifSameKeywordSet.close();
                        }
                    }

                    if (curAuthorPubs.size() != 0) {
                        List<Integer> samePubDocs = new ArrayList<>();
                        String samePubDocSql = "select distinct doc_id from article_info where publication_id in ( " + listToSqlList(curAuthorPubs) + " )";
                        ResultSet samePubDocSet = stmt.executeQuery(samePubDocSql);
                        while (samePubDocSet.next()) {
                            samePubDocs.add(samePubDocSet.getInt("doc_id"));
                        }
                        samePubDocSet.close();

                        if (samePubDocs.size() != 0) {
                            String ifSamePubSql = "select count(author_id) as bool from article_to_author where doc_id in ( " + listToSqlList(samePubDocs) + " ) and author_id = " + otsAuthorId;
                            ResultSet ifSamePubSet = stmt.executeQuery(ifSamePubSql);
                            ifSamePubSet.next();
                            // 在同期会议上发表文章加3
                            if (ifSamePubSet.getBoolean("bool")) {
                                preference += 3;
                            }
                            ifSamePubSet.close();
                        }
                    }

                    map.put(otsAuthorId, preference);
                }
            }

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    //计算作者相关度
    public Map<Integer, Integer> computAuthorRelation(int authorId, List<Integer> authorIds, List<Integer> recAuthorIds, int[][] records, Connection conn) {
        Map<Integer, Integer> map = new HashMap<>();
        try {
            Statement stmt = conn.createStatement();

            List<Integer> curAuthorDocs = new ArrayList<>();
            String allDocsSql = "select distinct doc_id from article_to_author where author_id = " + authorId;
            ResultSet curAuthorDocSet = stmt.executeQuery(allDocsSql);
            while (curAuthorDocSet.next()) {
                curAuthorDocs.add(curAuthorDocSet.getInt("doc_id"));
            }
            curAuthorDocSet.close();

            List<Integer> curAuthorAffls = new ArrayList<>();
            String allAfflsSql = "select distinct affiliation_id from author_info where author_id = " + authorId;
            ResultSet curAuthorAfflSet = stmt.executeQuery(allAfflsSql);
            while (curAuthorAfflSet.next()) {
                curAuthorAffls.add(curAuthorAfflSet.getInt("affiliation_id"));
            }
            curAuthorAfflSet.close();

            List<Integer> curAuthorkeywords = new ArrayList<>();
            String allKeywordsSql = "select distinct keyword_id from article_to_keyword where doc_id in ( " + listToSqlList(curAuthorDocs) + " )";
            ResultSet curAuthorKeywordSet = stmt.executeQuery(allKeywordsSql);
            while (curAuthorKeywordSet.next()) {
                curAuthorkeywords.add(curAuthorKeywordSet.getInt("keyword_id"));
            }
            curAuthorKeywordSet.close();

            List<Integer> curAuthorPubs = new ArrayList<>();
            String allPubsSql = "select distinct publication_id from article_info where doc_id in ( " + listToSqlList(curAuthorDocs) + " )";
            ResultSet curAuthorPubSet = stmt.executeQuery(allPubsSql);
            while (curAuthorPubSet.next()) {
                curAuthorPubs.add(curAuthorPubSet.getInt("publication_id"));
            }
            curAuthorPubSet.close();

            int authorCount = authorIds.size();
            for (int i = 0; i < authorCount; i++) {
                Integer otsAuthorId = authorIds.get(i);
                if (authorId != otsAuthorId) {
                    if (recAuthorIds.contains(otsAuthorId)) {
                        map.put(otsAuthorId, records[otsAuthorId - 1][authorId - 1]);
                    } else {
                        int preference = 0;

                        if (curAuthorDocs.size() != 0) {
                            String ifCoopedSql = "select count(doc_id) as bool from article_to_author where doc_id in ( " + listToSqlList(curAuthorDocs) + " ) and author_id = " + otsAuthorId;
                            ResultSet ifCoopedSet = stmt.executeQuery(ifCoopedSql);
                            ifCoopedSet.next();
                            // 合作过一篇文章加10
                            if (ifCoopedSet.getBoolean("bool")) {
                                preference += 10;
                            }
                            ifCoopedSet.close();
                        }

                        if (curAuthorAffls.size() != 0) {
                            String isInSameAfflSql = "select count(author_id) as bool from author_info where affiliation_id in ( " + listToSqlList(curAuthorAffls) + " ) and author_id = " + otsAuthorId;
                            ResultSet isInSameAfflSet = stmt.executeQuery(isInSameAfflSql);
                            isInSameAfflSet.next();
                            // 工作在同一个机构加5
                            if (isInSameAfflSet.getBoolean("bool")) {
                                preference += 5;
                            }
                            isInSameAfflSet.close();
                        }

                        if (curAuthorkeywords.size() != 0) {
                            List<Integer> sameKeywordDocs = new ArrayList<>();
                            String sameKeywordDocSql = "select distinct doc_id from article_to_keyword where keyword_id in ( " + listToSqlList(curAuthorkeywords) + " )";
                            ResultSet sameKeywordDocSet = stmt.executeQuery(sameKeywordDocSql);
                            while (sameKeywordDocSet.next()) {
                                sameKeywordDocs.add(sameKeywordDocSet.getInt("doc_id"));
                            }
                            sameKeywordDocSet.close();

                            if (sameKeywordDocs.size() != 0) {
                                String ifSameKeywordSql = "select count(author_id) as bool from article_to_author where doc_id in ( " + listToSqlList(sameKeywordDocs) + " ) and author_id = " + otsAuthorId;
                                ResultSet ifSameKeywordSet = stmt.executeQuery(ifSameKeywordSql);
                                ifSameKeywordSet.next();
                                // 文章有相同关键词加3
                                if (ifSameKeywordSet.getBoolean("bool")) {
                                    preference += 3;
                                }
                                ifSameKeywordSet.close();
                            }
                        }

                        if (curAuthorPubs.size() != 0) {
                            List<Integer> samePubDocs = new ArrayList<>();
                            String samePubDocSql = "select distinct doc_id from article_info where publication_id in ( " + listToSqlList(curAuthorPubs) + " )";
                            ResultSet samePubDocSet = stmt.executeQuery(samePubDocSql);
                            while (samePubDocSet.next()) {
                                samePubDocs.add(samePubDocSet.getInt("doc_id"));
                            }
                            samePubDocSet.close();

                            if (samePubDocs.size() != 0) {
                                String ifSamePubSql = "select count(author_id) as bool from article_to_author where doc_id in ( " + listToSqlList(samePubDocs) + " ) and author_id = " + otsAuthorId;
                                ResultSet ifSamePubSet = stmt.executeQuery(ifSamePubSql);
                                ifSamePubSet.next();
                                // 在同期会议上发表文章加3
                                if (ifSamePubSet.getBoolean("bool")) {
                                    preference += 3;
                                }
                                ifSamePubSet.close();
                            }
                        }

                        map.put(otsAuthorId, preference);
                        records[authorId - 1][otsAuthorId - 1] = preference;
                    }
                }
            }

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    public class Model {

        /**
         * userID
         */
        private int curAuthorId;

        /**
         * itemID
         */
        private int otsAuthorId;

        /**
         * preference
         */
        private int preference;

        public int getCurAuthorId() {
            return curAuthorId;
        }

        public void setCurAuthorId(int curAuthorId) {
            this.curAuthorId = curAuthorId;
        }

        public int getOtsAuthorId() {
            return otsAuthorId;
        }

        public void setOtsAuthorId(int otsAuthorId) {
            this.otsAuthorId = otsAuthorId;
        }

        public int getPreference() {
            return preference;
        }

        public void setPreference(int preference) {
            this.preference = preference;
        }

        public Model() {
        }

        public Model(int curAuthorId, int otsAuthorId, int preference) {
            this.curAuthorId = curAuthorId;
            this.otsAuthorId = otsAuthorId;
            this.preference = preference;
        }

        @Override
        public String toString() {
            return "Model{" +
                    "curAuthorId=" + curAuthorId +
                    ", otsAuthorId=" + otsAuthorId +
                    ", preference=" + preference +
                    '}';
        }

    }

    //用于将模型写入csv文件
    public void writeCSV(List<Model> dataList, String finalPath) {
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(finalPath);
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(osw);
            /**
             * 往CSV中写新数据
             */
            if (dataList != null && !dataList.isEmpty()) {
                for (Model data : dataList) {
                    bw.append(data.getCurAuthorId() + ",");
                    bw.append(data.getOtsAuthorId() + ",");
                    bw.append(Integer.toString(data.getPreference()));
                    bw.append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("作者行为数据导出成功");
    }

    public String listToSqlList(List list) {
        StringBuilder sqlList = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sqlList.append("'").append(list.get(i)).append("'");
            if (i != list.size() - 1) {
                sqlList.append(",");
            }
        }

        return sqlList.toString();
    }

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化链接作者数据用于绘制链接图
    public void initLinkedAuthors(Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            List<Integer> authorIds = new ArrayList<>();
            String authorSql = "select distinct author_id from author_info";
            ResultSet authorSet = stmt.executeQuery(authorSql);
            while (authorSet.next()) {
                authorIds.add(authorSet.getInt("author_id"));
            }
            authorSet.close();

            int[][] records = new int[4411][4411];

            List<Integer> recAuthorIds = new ArrayList<>();
            int authorCount = authorIds.size();
            for (int i = 1000; i < authorCount; i++) {
                int curAuthorId = authorIds.get(i);
                System.out.println("\nCurrent author: " + curAuthorId);
                List<Integer> linkedAuthorList = new ArrayList<>();
                List<Integer> coopCountList = new ArrayList<>();

                Map<Integer, Integer> map = computAuthorRelation(curAuthorId, authorIds, recAuthorIds, records, conn);
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > 5) {
                        linkedAuthorList.add(entry.getKey());
                        coopCountList.add(entry.getValue());
                    }
                }

                int size = linkedAuthorList.size();
                if (size > 0) {
                    for (int j = 0; j < size; j++) {
                        String insertSql = "insert into author_map (author_id, linked_author_id, coop_counts) values ( " + curAuthorId + ", " + linkedAuthorList.get(j) + ", " +  coopCountList.get(j) + " )";
                        stmt.execute(insertSql);
                    }
                }

                recAuthorIds.add(curAuthorId);
            }

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("链接作者数据初始化失败");
        }
    }


    //初始化方法的入口
    public void start() {
        try {
            Connection conn = initial_con("jdbc:mysql://localhost:3306/oasis?serverTimezone=UTC&useSSL=false", "root", "123456");
            readFromCsv(conn, "datasource/ase13_15_16_17_19.csv", "ase");
            System.out.println("ase数据初始化完毕");
            readFromCsv(conn, "datasource/icse15_16_17_18_19.csv", "icse");
            System.out.println("icse数据初始化完毕");
            initAuthorHindex(conn);
            System.out.println("作者的hindex初始化完毕");
            initAffiliationHindex(conn);
            System.out.println("机构的hindex初始化完毕");
            initAseHindex(conn);
            System.out.println("ase的hindex初始化完毕");
            initIcseHindex(conn);
            System.out.println("icse的hindex初始化完毕");
            initAuthorActivation(conn);
            System.out.println("作者的活跃度初始化完毕");
            initAffiliationActivation(conn);
            System.out.println("机构活跃度初始化完毕");
            initKeyWordActivation(conn);
            System.out.println("研究方向活跃度初始化完毕");
//            initDataModel(conn);
            initRelatedAuthors(conn, "datasource/model.csv");
            System.out.println("初始化相关作者推荐完毕");
            initLinkedAuthors(conn);
            System.out.println("初始化链接作者数据完毕");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //用于测试的main方法
    public static void main(String[] args) throws SQLException {
//        System.out.println("用于视频演示的提交3");
//        InitMySQL initMySQL = new InitMySQL();
//        double sum=0;
//        Connection connection= initMySQL.initial_con("jdbc:mysql://localhost:3306/oasis?serverTimezone=UTC&useSSL=false", "root", "123456");
//        for(int i=1;i<1000;i++){
//            double j=initMySQL.calKeyWordActivation(i,connection);
//            sum+=j;
//            System.out.println(j);
//        }
//        System.out.println(sum/999);
//        initMySQL.initKeyWordActivation(connection);
//
//
//
//        connection.close();


        //System.out.println(initMySQL.calAuthorActivation(5,connection));


//        int i=initMySQL.calTotalIcseHindex(initMySQL.initial_con("jdbc:mysql://localhost:3306/oasis?serverTimezone=UTC&useSSL=false", "root", "123456"));
//
//        //int i=initMySQL.calAseHindex(2013,initMySQL.initial_con("jdbc:mysql://localhost:3306/oasis?serverTimezone=UTC&useSSL=false", "root", "123456"));
//        //int i=initMySQL.calAffiliationHIndex(4,initMySQL.initial_con("jdbc:mysql://localhost:3306/oasis?serverTimezone=UTC&useSSL=false", "root", "123456"));
//        System.out.println(i);


    }

}
