package org.lieying.service.impl;

import org.lieying.bean.ArticleComment;
import org.lieying.dao.ArticleCommentMapper;
import org.lieying.service.ArticleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleCommentService")
public class ArticleCommentServiceImpl  implements ArticleCommentService {
    @Autowired
    private ArticleCommentMapper articleCommentMapper;


    @Override
    public ArticleComment queryArticleCommentById(int articleCommentId) {
        return articleCommentMapper.selectArticleCommentById(articleCommentId);
    }

    @Override
    public List<ArticleComment> queryArticleCommentsByArticleId(int articleId) {
        return articleCommentMapper.selectArticleCommentsByArticleId(articleId);
    }

    @Override
    public Boolean addArticleComment(ArticleComment articleComment) {
        System.out.println("content:"+articleComment.getContent());
        System.out.println("createdTime:"+articleComment.getCreatedTime());
        System.out.println("jobHunterId:"+articleComment.getJobHunter().getId());
        System.out.println("articleId:"+articleComment.getArticle().getId());
        return articleCommentMapper.insertArticleComment(articleComment.getContent(),articleComment.getCreatedTime(),
                articleComment.getJobHunter().getId(),articleComment.getArticle().getId())==1;
    }
}
