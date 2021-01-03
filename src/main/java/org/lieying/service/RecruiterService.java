package org.lieying.service;

import org.lieying.bean.Recruiter;

public interface RecruiterService {
     Recruiter queryRecruiterByUsernameAndPassword(String username,String password);
     Recruiter queryDetailRecruiterById(int recruiterId);
     Boolean addRecruiter(String username,String password, String phone);
}
