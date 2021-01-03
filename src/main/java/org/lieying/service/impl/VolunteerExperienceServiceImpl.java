package org.lieying.service.impl;

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
    public Boolean addVolunteerExperience(String name, String duration, Date startTime, Date endTime, String description, Integer resumeId) {

        return volunteerExperienceMapper.insertVolunteerExperience(name,duration,startTime,endTime,description,resumeId)==1;
    }
}
