package com.example.oasis.blImpl.show;

import com.example.oasis.po.Author;
import com.example.oasis.po.Paper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShowServiceImplTest {
    @Autowired
    private ShowServiceImpl showService;

    @Test
    void getPaperByTitle() {
        Paper paper=showService.getPaperByTitle("Toward Practical Automatic Program Repair");
        String expected="Paper{paper_id=749, Document_Title='Toward Practical Automatic Program Repair', Date_added_to_Xplore='', Abstract='Automated program repair (APR) reduces the burden of debugging by directly suggesting likely fixes for the bugs. We believe scalability| applicability| and accurate patch validation are among the main challenges for building practical APR techniques that the researchers in this area are dealing with. In this paper| we describe the steps that we are taking toward addressing these challenges.', ISSN='', ISBNs='', DOI='10.1109/ASE.2019.00156', PDF_Link='https://ieeexplore.ieee.org/stamp/stamp.jsp?arnumber=8952355', IEEE_Terms='', INSPEC_Controlled_Terms='', INSPEC_Non_Controlled_Terms='', Mesh_Terms='', Article_Citation_Count=0, Reference_Count=54, Online_Date='', Issue_Date='', Meeting_Date='', License=''}";
        //System.out.println(paper);
        assertEquals(expected,paper.toString());

    }

    @Test
    void getAuthorByName() {
        Author author=showService.getAuthorByName("A. Ghanbari");
        String expected="Author{author_id=2614, author_name='A. Ghanbari', author_affiliations='University of Texas at Dallas', author_keywords='Program Repair;JVM Bytecode;Mutation Testing', Funding_information='null'}";
        assertEquals(expected,author.toString());
        //System.out.println(author);
    }

    @Test
    void getRankPaper() {
        List<Paper> paperList=showService.getRankPaper();
        assertEquals(10,paperList.size());
    }

    @Test
    void getRankAuthor() {
        List<Author> authorList=showService.getRankAuthor();
        assertEquals(10,authorList.size());

    }
}