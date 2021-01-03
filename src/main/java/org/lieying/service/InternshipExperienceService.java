package org.lieying.service;


public interface InternshipExperienceService {
    Boolean addInternshipExperience( String company, String department,
                                    String positionCategory, String industry, String technology,
                                    String positionName, java.util.Date startTime,
                                    java.util.Date endTime, String jobContent,
                                    String jobPerformance, Integer resumeId);
}
