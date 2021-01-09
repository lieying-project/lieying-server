package org.lieying.service.impl;

import org.lieying.bean.VolunteerExperience;
import org.lieying.dao.VolunteerExperienceMapper;
import org.lieying.service.VolunteerExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class VolunteerExperienceServiceImpl implements VolunteerExperienceService {
    @Autowired
    private VolunteerExperienceMapper volunteerExperienceMapper;
    @Override
    public Boolean addVolunteerExperience(VolunteerExperience volunteerExperience) {
        try {
            return volunteerExperienceMapper.insertVolunteerExperience(
                    volunteerExperience.getName(),volunteerExperience.getDuration(),
                    volunteerExperience.getStartTime(),volunteerExperience.getEndTime(),
                    volunteerExperience.getDescription(),
                    volunteerExperience.getResume().getId())==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean modifyVolunteerExperience(VolunteerExperience volunteerExperience) {
        return volunteerExperienceMapper.updateVolunteerExperience(volunteerExperience.getId(),
                volunteerExperience.getName(),
                volunteerExperience.getDuration(),volunteerExperience.getStartTime(),volunteerExperience.getEndTime(),
                volunteerExperience.getDescription(),volunteerExperience.getResume().getId())==1;
    }
}
