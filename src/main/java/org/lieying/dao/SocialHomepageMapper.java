package org.lieying.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SocialHomepageMapper {
    int insertSocialHomepage(
            @Param("social_homepage_url") String url,
            @Param("social_homepage_sign") String sign,
            @Param("social_homepage_created_time") Date createdTime,
            @Param("social_homepage_updated_time") Date updatedTime,
            @Param("resume_id") Integer resumeId);

    int updateSocialHomepage(
            @Param("social_homepage_id") Integer id,
            @Param("social_homepage_url") String url,
            @Param("social_homepage_sign") String sign,
            @Param("social_homepage_created_time") Date createdTime,
            @Param("social_homepage_updated_time") Date updatedTime,
            @Param("resume_id") Integer resumeId);
}
