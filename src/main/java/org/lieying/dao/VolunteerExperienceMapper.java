package org.lieying.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface VolunteerExperienceMapper {
    int insertVolunteerExperience(
            @Param("volunteer_experience_name")String name,
            @Param("volunteer_experience_duration")String duaration,
            @Param("volunteer_experience_start_time") Date startTime,
            @Param("volunteer_experience_end_time") Date endTime,
            @Param("volunteer_experience_description") String description,
            @Param("resume_id")Integer resumeId);
    int updateVolunteerExperience(@Param("volunteer_experience_id")Integer volunteerExperienceId,
                                  @Param("volunteer_experience_name")String name,
                                  @Param("volunteer_experience_duration")String duaration,
                                  @Param("volunteer_experience_start_time") Date startTime,
                                  @Param("volunteer_experience_end_time") Date endTime,
                                  @Param("volunteer_experience_description") String description,
                                  @Param("resume_id")Integer resumeId);
}

