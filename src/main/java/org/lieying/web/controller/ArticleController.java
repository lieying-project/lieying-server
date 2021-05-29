package org.lieying.web.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lieying.bean.*;
import org.lieying.core.CommonResult;
import org.lieying.core.ResultGenerator;
import org.lieying.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping(value = "/{articleId}")
    public CommonResult articleDetail(@PathVariable int articleId) {
        return ResultGenerator.genSuccessfulResult(articleService.queryDetailArticleById(articleId));
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
    @GetMapping(value = "/list/{jobHunterId}")
    public CommonResult getArticlesByJobHunterId(@PathVariable int jobHunterId) {
        return ResultGenerator.genSuccessfulResult(articleService.queryArticlesByJobHunterId(jobHunterId));
    }

    /*
    * 分页查询所有文章
    * */
    @ApiOperation(value = "分页查询所有文章", notes = "分页查询所有文章")
    @GetMapping(value = "/list")
    public CommonResult getAllArticlesByPage(@RequestParam(value = "page", required = false) Integer page) {
        return ResultGenerator.genSuccessfulResult(articleService.queryAllArticlesByPage(page));
    }


    /*
    * 保存文章评论
    * */
    @ApiOperation(value = "保存文章评论", notes = "保存文章评论")
    @PostMapping(value = "/comment/save")
    public CommonResult saveArticleCommentRely(@RequestBody ArticleComment articleComment) {
        return ResultGenerator.genEditSuccessfulResult(articleCommentService.addArticleComment(articleComment));
    }



    /*
     * 保存评论回复
     * */
    @ApiOperation(value = "保存评论回复", notes = "保存评论回复")
    @PostMapping(value = "/comment/rely/save")
    public CommonResult saveArticleCommentRely(@RequestBody ArticleCommentRely articleCommentRely) {
        return ResultGenerator.genEditSuccessfulResult(articleCommentRelyService.addArticleCommentRely(articleCommentRely));
    }


    /*
     * 点赞文章
     * */
    @ApiOperation(value = "点赞文章", notes = "点赞文章")
    @PostMapping(value = "/praise/save")
    public CommonResult saveArticlePraise(@RequestBody ArticlePraise articlePraise) {
        return ResultGenerator.genEditSuccessfulResult(articlePraiseService.addArticlePraise(articlePraise));
    }



    /*
     * 取消点赞文章
     * */
    @ApiOperation(value = "取消点赞文章", notes = "取消点赞文章")
    @DeleteMapping(value = "/praise/delete/{id}")
    public CommonResult deleteArticlePraise(@PathVariable int id) {
        return ResultGenerator.genDeleteSuccessfulResult(articlePraiseService.removeArticlePraise(id));
    }

    /*
     * 收藏文章
     * */
    @ApiOperation(value = "收藏文章", notes = "收藏文章")
    @PostMapping(value = "/collect/save")
    public CommonResult saveArticleCollect(@RequestBody ArticleCollect articleCollect) {
        return ResultGenerator.genEditSuccessfulResult(articleCollectService.addArticleCollect(articleCollect));
    }


    /*
     * 取消收藏文章
     * */
    @ApiOperation(value = "取消收藏文章", notes = "取消收藏文章")
    @DeleteMapping(value = "/collect/delete/{id}")
    public CommonResult deleteArticleCollect(@PathVariable int id) {
        return ResultGenerator.genDeleteSuccessfulResult(articleCollectService.removeArticleCollect(id));
    }



    /*
     * 保存文章
     * */
    @ApiOperation(value = "保存文章", notes = "保存文章")
    @PostMapping(value = "/save")
    public CommonResult saveArticle(@RequestBody Article article) {
        // System.out.println("articleComment:"+articleComment);
        return ResultGenerator.genEditSuccessfulResult(articleService.addArticle(article));
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
