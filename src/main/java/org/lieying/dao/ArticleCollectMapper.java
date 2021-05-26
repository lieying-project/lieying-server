package org.lieying.dao;


import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface ArticleCollectMapper {

    int insertArticleCollect(@Param("article_collect_created_time")Date createdTime,
                             @Param("article_id")Integer articleId,
                             @Param("job_hunter_id")Integer jobHunterId);
    int deleteArticleCollect(int id);
}
