package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lieying.bean.*;
import org.lieying.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@Api(value = "文章信息接口", tags = "文章信息")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleCommentService articleCommentService;
    @Autowired
    private ArticleCommentRelyService articleCommentRelyService;
    @Autowired
    private ArticleCollectService articleCollectService;
    @Autowired
    private ArticlePraiseService articlePraiseService;

    //文章详情
    @ApiOperation(value = "文章详情", notes = "文章详情")
    @RequestMapping(value = "/{articleId}", produces = "text/plain;charset=UTF-8")
    public String articleDetail(@PathVariable int articleId) {
        return JSON.toJSONString(articleService.queryDetailArticleById(articleId));
    }

    //    @RequestMapping("/{articleId}/comments")
//    public List<ArticleComment> articleComments(@PathVariable int articleId){
//        return articleCommentService.queryArticleCommentsByArticleId(articleId);
//    }
    /*
     *
     *  求职者发布的所有文章
     *  @param  jobHunterId  求职者id
     *
     */
    @ApiOperation(value = "查询求职者发表的所有文章", notes = "查询求职者发表的所有文章")
    @RequestMapping(value = "/list/{jobHunterId}", produces = "text/plain;charset=UTF-8")
    public String getArticlesByJobHunterId(@PathVariable int jobHunterId) {
        return JSON.toJSONString(articleService.queryArticlesByJobHunterId(jobHunterId));
    }

    /*
    * 分页查询所有文章
    * */
    @ApiOperation(value = "分页查询所有文章", notes = "分页查询所有文章")
    @RequestMapping(value = "/list", produces = "text/plain;charset=utf-8")
    public String getAllArticlesByPage(@RequestParam(value = "page", required = false) Integer page) {
        return JSON.toJSONString(articleService.queryAllArticlesByPage(page));
    }


    /*
    * 保存文章评论
    * */
    @ApiOperation(value = "保存文章评论", notes = "保存文章评论")
    @PostMapping(value = "/comment/save", produces = "text/plain;charset=UTF-8")
    public String saveArticleCommentRely(@RequestBody ArticleComment articleComment) {
        return JSON.toJSONString(articleCommentService.addArticleComment(articleComment));
    }



    /*
     * 保存评论回复
     * */
    @ApiOperation(value = "保存评论回复", notes = "保存评论回复")
    @PostMapping(value = "/comment/rely/save", produces = "text/plain;charset=UTF-8")
    public String saveArticleCommentRely(@RequestBody ArticleCommentRely articleCommentRely) {
        return JSON.toJSONString(articleCommentRelyService.addArticleCommentRely(articleCommentRely));
    }


    /*
     * 点赞文章
     * */
    @ApiOperation(value = "点赞文章", notes = "点赞文章")
    @PostMapping(value = "/praise/save", produces = "text/plain;charset=UTF-8")
    public String saveArticlePraise(@RequestBody ArticlePraise articlePraise) {
        return JSON.toJSONString(articlePraiseService.addArticlePraise(articlePraise));
    }



    /*
     * 取消点赞文章
     * */
    @ApiOperation(value = "取消点赞文章", notes = "取消点赞文章")
    @PostMapping(value = "/praise/delete/{id}", produces = "text/plain;charset=UTF-8")
    public String deleteArticlePraise(@PathVariable int id) {
        return JSON.toJSONString(articlePraiseService.removeArticlePraise(id));
    }

    /*
     * 收藏文章
     * */
    @ApiOperation(value = "收藏文章", notes = "收藏文章")
    @PostMapping(value = "/collect/save", produces = "text/plain;charset=UTF-8")
    public String saveArticleCollect(@RequestBody ArticleCollect articleCollect) {
        return JSON.toJSONString(articleCollectService.addArticleCollect(articleCollect));
    }


    /*
     * 取消收藏文章
     * */
    @ApiOperation(value = "取消收藏文章", notes = "取消收藏文章")
    @PostMapping(value = "/collect/delete/{id}", produces = "text/plain;charset=UTF-8")
    public String deleteArticleCollect(@PathVariable int id) {
        return JSON.toJSONString(articleCollectService.removeArticleCollect(id));
    }



    /*
     * 保存文章
     * */
    @ApiOperation(value = "保存文章", notes = "保存文章")
    @PostMapping(value = "/save", produces = "text/plain;charset=utf-8")
    public String saveArticle(@RequestBody Article article) {
        // System.out.println("articleComment:"+articleComment);
        return JSON.toJSONString(articleService.addArticle(article));
    }
//    @PostMapping(value = "/save",produces = "text/plain;charset=UTF-8")
//    public String saveArticle(@RequestBody Article article){
//
//        Boolean result=articleService.addArticle(article);
//        System.out.println(article);
//        if (result){
//            return String.valueOf(article.getId());
//        }
//        return  JSON.toJSONString(result);
//    }

}
