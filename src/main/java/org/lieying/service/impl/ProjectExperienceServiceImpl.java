package org.lieying.service.impl;

import org.lieying.dao.ProjectExperienceMapper;
import org.lieying.service.ProjectExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectExperienceServiceImpl implements ProjectExperienceService {
    @Autowired
    private ProjectExperienceMapper projectExperienceMapper;
    @Override
    public Boolean addProjectExperience(String name, String role, String url, java.util.Date  startTime, java.util.Date  endTime, String desc, String performance, Integer resumeId) {
        try {
            return projectExperienceMapper.insertProjectExperience(name,role,url,startTime,endTime,desc,performance,resumeId)==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
