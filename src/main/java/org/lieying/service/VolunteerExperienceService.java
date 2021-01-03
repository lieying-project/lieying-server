package org.lieying.service;

public interface VolunteerExperienceService {
    Boolean addVolunteerExperience(String name,String duration,java.util.Date startTime,
                                   java.util.Date endTime,
                                  String description,
                                  Integer resumeId);
}
