package org.lieying.dao;
import org.apache.ibatis.annotations.Param;
import org.lieying.bean.ArticleCommentRely;

import java.util.Date;
import java.util.List;
public interface ArticleCommentRelyMapper {
    ArticleCommentRely selectArticleCommentRelyById(int articleCommentRelyId);
    List<ArticleCommentRely> selectArticleCommentReliesByArticleCommentId(int articleCommentId);
    int insertArticleCommentRely(@Param("article_comment_rely_content")String content,
                                 @Param("article_comment_rely_created_time")Date createdTime,
                                 @Param("article_comment_rely_updated_time")Date updatedTime,
                                 @Param("article_comment_id")Integer articleCommentId,
                                 @Param("parent_article_comment_rely_id")Integer articleCommentRelyId,
                                 @Param("job_hunter_id")Integer jobHunterId);


}
