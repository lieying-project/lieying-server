package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.EducationExperience;
import org.lieying.bean.Resume;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

public interface EducationExperienceMapper {


    int insertEducationExperience(
            @Param("education_experience_school") String school,
            @Param("education_experience_profession") String profession,
            @Param("education_experience_time_quantum") String timeQuantum,
            @Param("education_experience_school_experience") String schoolExperience,
            @Param("education_experience_stage") String stage,
            @Param("resume_id") Integer resumeId);

    int updateEducationExperience(@Param("education_experience_id") Integer id,
                                  @Param("education_experience_school") String school,
                                  @Param("education_experience_profession") String profession,
                                  @Param("education_experience_time_quantum") String timeQuantum,
                                  @Param("education_experience_school_experience") String schoolExperience,
                                  @Param("education_experience_stage") String stage,
                                  @Param("resume_id") Integer resumeId);
}
