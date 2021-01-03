package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Article;

import java.util.Date;
import java.util.List;

public interface ArticleMapper {

    List<Article> selectArticlesByJobHunterId(int jobHunterId);


    Article selectDetailArticleById(int articleId);

    List<Article> selectAllArticles();

    int insertArticle(@Param("article_title") String title,
                      @Param("article_content") String content,
                      @Param("article_created_time") Date createdTime,
                      @Param("article_updated_time") Date updatedTime,
                      @Param("job_hunter_id") Integer jobHunterId);
}

