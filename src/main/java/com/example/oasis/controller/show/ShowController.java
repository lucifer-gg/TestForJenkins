package com.example.oasis.controller.show;

import com.example.oasis.blImpl.show.ShowServiceImpl;
import com.example.oasis.po.Author;
import com.example.oasis.po.Paper;
import com.example.oasis.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ShowController {
    @Autowired
    private ShowServiceImpl showServiceImpl;

    @Autowired
    public ShowController(ShowServiceImpl showServiceImpl) {
        this.showServiceImpl = showServiceImpl;
    }

    /**
     * @类名 ShowController
     * @创建人 Chen Hongyu
     * @描述 根据论文标题返回论文详细数据
     */
    @RequestMapping(value = "/paper", method = RequestMethod.POST)
    public ResponseVO getPaper(PaperVO paperForm) {
        String title = paperForm.getDocument_Title();
        Paper paper = showServiceImpl.getPaperByTitle(title);
        if (paper == null) {
            return ResponseVO.buildFailure("作者不存在");
        } else {
            PaperVO paperVO = new PaperVO(paper);
            return ResponseVO.buildSuccess(paperVO);
        }


    }

    /**
     * @类名 ShowController
     * @创建人 Chen Hongyu
     * @描述 根据作者姓名返回作者的详细信息
     */
    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public ResponseVO getAuthor(AuthorVO authorForm) {
        String name = authorForm.getAuthor_name();
        Author author = showServiceImpl.getAuthorByName(name);
        if (author == null) {
            return ResponseVO.buildFailure("论文不存在");
        } else {
            AuthorVO authorVO = new AuthorVO(author);
            return ResponseVO.buildSuccess(authorVO);
        }
    }

    /**
     * @描述 根据作者发表论文数量返回作者排名
     * @参数 []
     * @返回值 com.example.oasis.vo.ResponseVO
     * @创建人 Chen Hongyu
     */
    @RequestMapping(value = "/rankauthor", method = RequestMethod.GET)
    public ResponseVO rankAuthor() {
        List<Author> authors = showServiceImpl.getRankAuthor();
        RankAuthor rankAuthor = new RankAuthor(authors);
        return ResponseVO.buildSuccess(rankAuthor);
    }

    /**
     * @描述 根据论文的引用数量返回论文排名
     * @参数 []
     * @返回值 com.example.oasis.vo.ResponseVO
     * @创建人 Chen Hongyu
     */
    @RequestMapping(value = "/rankpaper", method = RequestMethod.GET)
    public ResponseVO rankPaper() {
        List<Paper> papers = showServiceImpl.getRankPaper();
        RankPaper rankPaper = new RankPaper(papers);
        return ResponseVO.buildSuccess(rankPaper);
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseVO rankPaper1() {
        return ResponseVO.buildSuccess("第六次测试成功");
    }

}
