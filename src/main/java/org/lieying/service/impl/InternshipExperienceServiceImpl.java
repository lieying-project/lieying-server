package org.lieying.service.impl;

import org.lieying.bean.InternshipExperience;
import org.lieying.dao.InternshipExperienceMapper;
import org.lieying.service.InternshipExperienceService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InternshipExperienceServiceImpl implements InternshipExperienceService {
    @Autowired
    private InternshipExperienceMapper internshipExperienceMapper;

    @Override
    public Boolean addInternshipExperience(InternshipExperience internshipExperience) {
        try {
            return internshipExperienceMapper.insertInternshipExperience(internshipExperience.getCompany(),
                    internshipExperience.getDepartment(), internshipExperience.getPositionCategory(),
                    internshipExperience.getIndustry(), internshipExperience.getTechnology(),
                    internshipExperience.getPositionName(), internshipExperience.getStartTime(),
                    internshipExperience.getEndTime(), internshipExperience.getJobContent(),
                    internshipExperience.getJobPerformance(), internshipExperience.getResume().getId()) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean modifyInternshipExperience(InternshipExperience internshipExperience) {
        try {
            return internshipExperienceMapper.updateInternshipExperience(internshipExperience.getId(),
                    internshipExperience.getCompany(),
                    internshipExperience.getDepartment(), internshipExperience.getPositionCategory(),
                    internshipExperience.getIndustry(), internshipExperience.getTechnology(),
                    internshipExperience.getPositionName(), internshipExperience.getStartTime(),
                    internshipExperience.getEndTime(), internshipExperience.getJobContent(),
                    internshipExperience.getJobPerformance(), internshipExperience.getResume().getId()) ==1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
