package org.lieying.service.impl;


import org.lieying.bean.EducationExperience;
import org.lieying.dao.EducationExperienceMapper;
import org.lieying.service.EducationExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationExperienceServiceImpl implements EducationExperienceService {

    @Autowired
    private EducationExperienceMapper educationExperienceMapper;
    @Override
    public Boolean addEducationExperience(EducationExperience educationExperience) {
        try {
            return educationExperienceMapper.insertEducationExperience(educationExperience.getSchool(),
                    educationExperience.getProfession(),educationExperience.getTimeQuantum(),
                    educationExperience.getSchoolExperience(),educationExperience.getStage(),educationExperience.getResume().getId())==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Boolean updateEducationExperience(EducationExperience educationExperience) {

        try {
            return educationExperienceMapper.updateEducationExperience(educationExperience.getId(),educationExperience.getSchool(),
                    educationExperience.getProfession(),educationExperience.getTimeQuantum(),
                    educationExperience.getSchoolExperience(),educationExperience.getStage(),educationExperience.getResume().getId())==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }
}
