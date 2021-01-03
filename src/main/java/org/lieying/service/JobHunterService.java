package org.lieying.service;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.JobHunter;

import java.util.Date;
import java.util.List;

public interface JobHunterService {
    List<JobHunter> queryAllJobHunter();

    JobHunter queryDetailJobHunterById(int jobHunterId);

    JobHunter queryJobHunterByUsernameAndPassword(String username, String password);

    Boolean addJobHunter(String username, String password, String phone);

    Boolean updateJobHunter(int id, String username, String password,
                            String email, String phone, String name, String sex,
                            Date birthday, String photo, String education,
                            String interest, String address);

}
