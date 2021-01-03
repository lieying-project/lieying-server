package org.lieying.dao;

import org.apache.ibatis.annotations.Param;

public interface InternshipExperienceMapper {

    int insertInternshipExperience(
            @Param("internship_experience_company") String company,
            @Param("internship_experience_department") String department,
            @Param("internship_experience_position_category") String positionCategory,
            @Param("internship_experience_industry") String industry,
            @Param("internship_experience_technology") String technology,
            @Param("internship_experience_position_name") String positionName,
            @Param("internship_experience_start_time") java.util.Date startTime,
            @Param("internship_experience_end_time") java.util.Date endTime,
            @Param("internship_experience_job_content") String jobContent,
            @Param("internship_experience_job_performance") String jobPerformance,
            @Param("resume_id") Integer resumeId);
}
