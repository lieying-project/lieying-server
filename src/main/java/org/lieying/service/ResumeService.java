package org.lieying.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Resume;

import java.util.List;

public interface ResumeService {
    List<Resume> queryResumesByJobHunterId(int jobHunterId);

    Resume queryResumeById(int resumeId);

    Boolean modifyResume(Resume resume);

    Boolean addResume(Resume resume);

    boolean removeResume(int id);
    boolean updateResumeNameById(int id,String name);
}
