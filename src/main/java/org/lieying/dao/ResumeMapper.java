package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Resume;

import java.util.List;

public interface ResumeMapper {


     List<Resume> selectResumesByJobHunterId(int jobHunterId);
     Resume selectResumeById(int resumeId);
     int updateResume(
             @Param("resume_id")Integer resumeId,
             @Param("resume_name")String name,
             @Param("resume_education")String education,
             @Param("resume_age")int age,
             @Param("resume_advantage")String advantage,
             @Param("resume_expected_city")String expectedCity,
             @Param("resume_expected_position")String expectedPosition,
             @Param("resume_expected_salary")String expectedSalary,
             @Param("resume_work_address")String workAddress,
             @Param("resume_work_experience")String workExperience,
             @Param("resume_project_experience")String projectExperience,
             @Param("resume_social_homepage")String socialHomepage,
             @Param("resume_volunteer_service_experience")String volunteerServiceExperience,
             @Param("resume_enclosure")String enclosure,
             @Param("resume_reject_reason")String rejectReason,
             @Param("resume_created_time")java.util.Date createdTime,
             @Param("resume_updated_time")java.util.Date updatedTime,
             @Param("resume_delivered_time")java.util.Date deliveredTime,
             @Param("resume_state")String state,
             @Param("job_hunter_id")Integer jobHunterId,
             @Param("position_id")Integer position_id);
     int insertResume(@Param("resume_name")String name,
                      @Param("resume_education")String education,
                      @Param("resume_age")int age,
                      @Param("resume_advantage")String advantage,
                      @Param("resume_expected_city")String expectedCity,
                      @Param("resume_expected_position")String expectedPosition,
                      @Param("resume_expected_salary")String expectedSalary,
                      @Param("resume_work_address")String workAddress,
                      @Param("resume_work_experience")String workExperience,
                      @Param("resume_project_experience")String projectExperience,
                      @Param("resume_social_homepage")String socialHomepage,
                      @Param("resume_volunteer_service_experience")String volunteerServiceExperience,
                      @Param("resume_enclosure")String enclosure,
                      @Param("resume_reject_reason")String rejectReason,
                      @Param("resume_created_time")java.util.Date createdTime,
                      @Param("resume_updated_time")java.util.Date updatedTime,
                      @Param("resume_delivered_time")java.util.Date deliveredTime,
                      @Param("resume_state")String state,
                      @Param("job_hunter_id")Integer jobHunterId,
                      @Param("position_id")Integer positionId);
     int deleteResume(int id);
     int updateResumeNameById(@Param("resume_id") int id,
                              @Param("resume_name") String name);
}
