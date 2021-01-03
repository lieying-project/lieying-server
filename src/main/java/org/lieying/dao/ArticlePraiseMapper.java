package org.lieying.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface ArticlePraiseMapper {
    int insertArticlePraise(@Param("article_praise_created_time") Date createdTime,
                             @Param("article_id")Integer articleId,
                             @Param("job_hunter_id")Integer jobHunterId);
    int deleteArticlePraise(int id);
}
