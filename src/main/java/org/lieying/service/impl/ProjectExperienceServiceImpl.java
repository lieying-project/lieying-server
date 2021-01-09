package org.lieying.service.impl;

import org.lieying.bean.ProjectExperience;
import org.lieying.dao.ProjectExperienceMapper;
import org.lieying.service.ProjectExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectExperienceServiceImpl implements ProjectExperienceService {
    @Autowired
    private ProjectExperienceMapper projectExperienceMapper;
    @Override
    public Boolean addProjectExperience(ProjectExperience projectExperience) {
        try {
            return projectExperienceMapper.insertProjectExperience(projectExperience.getName(),
                    projectExperience.getRole(),projectExperience.getUrl(),
                    projectExperience.getStartTime(), projectExperience.getEndTime(),
                    projectExperience.getDescription(),projectExperience.getPerformance(),
                    projectExperience.getResume().getId())==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean modifyProjectExperience(ProjectExperience projectExperience) {
        try {
            return projectExperienceMapper.updateProjectExperience(projectExperience.getId(),
                    projectExperience.getName(),
                    projectExperience.getRole(),projectExperience.getUrl(),
                    projectExperience.getStartTime(), projectExperience.getEndTime(),
                    projectExperience.getDescription(),projectExperience.getPerformance(),
                    projectExperience.getResume().getId())==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
