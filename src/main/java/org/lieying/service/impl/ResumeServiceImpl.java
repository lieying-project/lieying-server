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
    public Boolean modifyResume(Resume resume) {
        Integer jobHunterId=null;
        Integer positionId=null;
        if (resume.getJobHunter()!=null){
            jobHunterId=resume.getJobHunter().getId();
        }
        if (resume.getPosition()!=null){
            positionId=resume.getPosition().getId();
        }
      try{
          return resumeMapper.updateResume(
                 resume.getId(),resume.getName(),resume.getEducation(),resume.getAge(),
                  resume.getAdvantage(),resume.getExpectedCity(),resume.getExpectedPosition(),
                  resume.getExpectedSalary(),resume.getWorkAddress(),resume.getWorkExperience(),
                  resume.getProjectExperience(),resume.getVolunteerServiceExperience(),
                  resume.getEnclosure(),resume.getRejectReason(),resume.getCreatedTime(),resume.getUpdatedTime(),
                  resume.getDeliveredTime(),resume.getState(),jobHunterId,positionId) == 1 ;
      }catch (Exception e){
          e.printStackTrace();
          return false;
      }

    }

    @Override
    public Boolean addResume(Resume resume) {
        Integer jobHunterId=null;
        Integer positionId=null;
        if (resume.getJobHunter()!=null){
            jobHunterId=resume.getJobHunter().getId();
        }
        if (resume.getPosition()!=null){
            positionId=resume.getPosition().getId();
        }
        if (positionId==null){

            return resumeMapper.insertResume2( resume.getName(),jobHunterId,new Date(),new Date())==1;
        }
       return resumeMapper.insertResume( resume.getName(),  resume.getEducation(),  resume.getAge(),  resume.getAdvantage(),
               resume.getExpectedCity(),  resume.getExpectedPosition(),
               resume.getExpectedSalary(), resume.getWorkAddress(),  resume.getWorkExperience(),
               resume.getProjectExperience(),  resume.getVolunteerServiceExperience(),
               resume.getEnclosure(),  resume.getRejectReason(),  resume.getCreatedTime(),  resume.getUpdatedTime(),
               resume.getDeliveredTime(),  resume.getState(),jobHunterId,positionId)==1;
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
