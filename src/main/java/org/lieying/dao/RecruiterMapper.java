package org.lieying.dao;


import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Recruiter;

public interface RecruiterMapper {
     Recruiter selectRecruiterByUsernameAndPassword(@Param("recruiter_username")String username,@Param("recruiter_password")String password);
     Recruiter selectDetailRecruiterById(int recruiterId);
     int insertRecruiter(@Param("recruiter_username")String username,
                         @Param("recruiter_name")String name,
                         @Param("recruiter_intro")String intro,
                         @Param("recruiter_password")String password,
                         @Param("recruiter_position")String position ,
                         @Param("recruiter_phone")String phone,
                         @Param("recruiter_photo")String photo);
}
