package org.lieying.service.impl;

import org.lieying.dao.InternshipExperienceMapper;
import org.lieying.service.InternshipExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InternshipExperienceServiceImpl implements InternshipExperienceService {
    @Autowired
    private InternshipExperienceMapper internshipExperienceMapper;
    @Override
    public Boolean addInternshipExperience(String company, String department, String positionCategory, String industry, String technology,
                                           String positionName, Date startTime, Date endTime, String jobContent,
                                           String jobPerformance, Integer resumeId) {
        return internshipExperienceMapper.insertInternshipExperience(company,department,positionCategory,industry,
                technology,positionName,startTime,endTime,jobContent,jobPerformance,resumeId)==1;
    }
}
