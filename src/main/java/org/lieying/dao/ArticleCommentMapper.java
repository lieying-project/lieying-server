package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.ArticleComment;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface ArticleCommentMapper {
    ArticleComment selectArticleCommentById(int articleCommentId);
    List<ArticleComment> selectArticleCommentsByArticleId(int articleId);

    int insertArticleComment(@Param("article_comment_content") String content,
                             @Param("article_comment_created_time")Date createdTime,
                             @Param("job_hunter_id")Integer jobHunterId,
                             @Param("article_id")Integer articleId);

}
