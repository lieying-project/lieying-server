package org.lieying.dao;

import org.apache.ibatis.annotations.Param;

public interface ProjectExperienceMapper {
    int insertProjectExperience(
            @Param("project_experience_name")String name,
            @Param("project_experience_role")String role,
            @Param("project_experience_url")String url,
            @Param("project_experience_start_time")java.util.Date startTime,
            @Param("project_experience_end_time")java.util.Date  endTime,
            @Param("project_experience_description")String desc,
            @Param("project_experience_performance")String performance,
            @Param("resume_id")Integer resumeId);
    int updateProjectExperience(
            @Param("project_experience_id")Integer projectExperienceId,
            @Param("project_experience_name")String name,
            @Param("project_experience_role")String role,
            @Param("project_experience_url")String url,
            @Param("project_experience_start_time")java.util.Date startTime,
            @Param("project_experience_end_time")java.util.Date  endTime,
            @Param("project_experience_description")String desc,
            @Param("project_experience_performance")String performance,
            @Param("resume_id")Integer resumeId
    );


}
