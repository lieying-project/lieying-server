package org.lieying.dao;

import cn.pomit.jpamapper.core.mapper.CrudMapper;
import org.apache.ibatis.annotations.Param;
import org.lieying.bean.JobHunter;

import java.util.Date;
import java.util.List;

//@Mapper
public interface JobHunterMapper extends CrudMapper<JobHunter, Integer> {

    //@Select("select * from job_hunter")
    List<JobHunter> selectAllJobHunter();
    JobHunter selectDetailJobHunterById(int jobHunterId);
    JobHunter selectJobHunterByUsernameAndPassword(
            @Param("job_hunter_username") String username, @Param("job_hunter_password") String password);

    int insertJobHunter(@Param("job_hunter_username") String username,
                        @Param("job_hunter_password") String password,
                        @Param("job_hunter_email") String email,
                        @Param("job_hunter_phone") String phone,
                        @Param("job_hunter_name") String name,
                        @Param("job_hunter_sex") String sex,
                        @Param("job_hunter_birthday") Date birthday,
                        @Param("job_hunter_photo") String photo,
                        @Param("job_hunter_education") String education,
                        @Param("job_hunter_interest") String interest,
                        @Param("job_hunter_address") String address);
    int updateJobHunter(
            @Param("job_hunter_id") int id,
            @Param("job_hunter_username") String username,
            @Param("job_hunter_password") String password,
            @Param("job_hunter_email") String email,
            @Param("job_hunter_phone") String phone,
            @Param("job_hunter_name") String name,
            @Param("job_hunter_sex") String sex,
            @Param("job_hunter_birthday") Date birthday,
            @Param("job_hunter_photo") String photo,
            @Param("job_hunter_education") String education,
            @Param("job_hunter_interest") String interest,
            @Param("job_hunter_address") String address);
}
