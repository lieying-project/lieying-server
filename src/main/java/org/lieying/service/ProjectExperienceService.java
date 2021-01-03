package org.lieying.service;

import org.apache.ibatis.annotations.Param;

public interface ProjectExperienceService {
    Boolean addProjectExperience(String name, String role, String url, java.util.Date  startTime,
                                 java.util.Date  endTime, String desc, String performance, Integer resumeId);
}
