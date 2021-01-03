package org.lieying.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Resume;

import java.util.List;

public interface ResumeService {
    List<Resume> queryResumesByJobHunterId(int jobHunterId);

    Resume queryResumeById(int resumeId);

    Boolean modifyResumeState(Resume resume);

    Boolean addResume(String name,
                      String education,
                      int age,
                      String advantage,
                      String expectedCity,
                      String expectedPosition,
                      String expectedSalary,
                      String workAddress,
                      String workExperience,
                      String projectExperience,
                      String socialHomepage,
                      String volunteerServiceExperience,
                      String enclosure,
                      String rejectReason,
                      java.util.Date createdTime,
                      java.util.Date updatedTime,
                      java.util.Date deliveredTime,
                      String state);

    boolean removeResume(int id);
    boolean updateResumeNameById(int id,String name);
}
