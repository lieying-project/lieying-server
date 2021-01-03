package org.lieying.service.impl;

import org.lieying.bean.ArticleCommentRely;
import org.lieying.dao.ArticleCommentRelyMapper;
import org.lieying.service.ArticleCommentRelyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticleCommentRelyServiceImpl implements ArticleCommentRelyService {

    @Autowired
    private ArticleCommentRelyMapper articleCommentRelyMapper;
    @Override
    public Boolean addArticleCommentRely(ArticleCommentRely articleCommentRely) {
        Date createdTime = articleCommentRely.getCreatedTime();
        Date updatedTime=articleCommentRely.getUpdatedTime();
        String content=articleCommentRely.getContent();
        Integer jobHunterId = null, articleCommentId = null, articleCommentRelyId = null;
        if ( articleCommentRely.getJobHunter()!=null){
            jobHunterId=articleCommentRely.getJobHunter().getId();
        }
        if (articleCommentRely.getParentArticleCommentRely()!=null){
            articleCommentRelyId=articleCommentRely.getParentArticleCommentRely().getId();
        }
        if (articleCommentRely.getArticleComment()!=null){
            articleCommentId=articleCommentRely.getArticleComment().getId();
        }
        System.out.println("content:"+content);
        System.out.println("createdTime:"+createdTime);
        System.out.println("updatedTime:"+updatedTime);

        System.out.println("jobHunterId:"+jobHunterId);
        System.out.println(articleCommentId);
        System.out.println(articleCommentRelyId);
        return  articleCommentRelyMapper.insertArticleCommentRely(content,createdTime,updatedTime,
                articleCommentId, articleCommentRelyId,jobHunterId)==1;


    }
}
