package org.lieying.service.impl;

import org.lieying.bean.Resume;
import org.lieying.dao.ResumeMapper;
import org.lieying.exception.NullObjectAttributeException;
import org.lieying.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    //    @Cacheable(value = "cache1")
    @Transactional(readOnly = true)
    @Override
    public List<Resume> queryResumesByJobHunterId(int jobHunterId) {
        return resumeMapper.selectResumesByJobHunterId(jobHunterId);
    }

    //    @Cacheable(value = "cache1")
    @Transactional(readOnly = true)
    @Override
    public Resume queryResumeById(int resumeId) {
        return resumeMapper.selectResumeById(resumeId);
    }

    @Override
    public Boolean modifyResumeState(Resume resume) {
        if (resume.getJobHunter() == null) {
            throw new NullObjectAttributeException("");
        } else if (resume.getPosition() == null) {
            throw new NullObjectAttributeException("");
        }
        return resumeMapper.updateResumeStateByJobHunterIdAndPositionId(
                resume.getJobHunter().getId(), resume.getPosition().getId(), resume.getState()) == 1 ;
    }

    @Override
    public Boolean addResume(String name, String education, int age, String advantage, String expectedCity, String expectedPosition, String expectedSalary, String workAddress, String workExperience, String projectExperience, String socialHomepage, String volunteerServiceExperience, String enclosure, String rejectReason, Date createdTime, Date updatedTime, Date deliveredTime, String state) {
       return resumeMapper.insertResume( name,  education,  age,  advantage,  expectedCity,  expectedPosition,  expectedSalary,  workAddress,  workExperience,  projectExperience,  socialHomepage,  volunteerServiceExperience,  enclosure,  rejectReason,  createdTime,  updatedTime,  deliveredTime,  state)==1;
    }
    @Override
    public boolean removeResume(int id) {
        return resumeMapper.deleteResume(id)==1;
    }

    @Override
    public boolean updateResumeNameById(int id, String name) {
        return resumeMapper.updateResumeNameById(id,name)==1;
    }
}
