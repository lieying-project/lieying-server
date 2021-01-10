package org.lieying.service.impl;
import org.lieying.bean.JobHunter;
import org.lieying.dao.JobHunterMapper;
import org.lieying.service.JobHunterService;
import org.lieying.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class JobHunterServiceImpl  implements JobHunterService {
    @Autowired
    private JobHunterMapper jobHunterMapper;

//    @Cacheable(value = "cache1")
    @Transactional(readOnly = true)
    @Override
    public List<JobHunter> queryAllJobHunter() {
       //return (List<JobHunter>) jobHunterDao.findAll();
        return jobHunterMapper.selectAllJobHunter();
    }

    @Override
    public JobHunter queryDetailJobHunterById(int jobHunterId) {
        return jobHunterMapper.selectDetailJobHunterById(jobHunterId);
    }

    @Override
    public JobHunter queryJobHunterByUsernameAndPassword(String username, String password) {
        JobHunter jobHunter1=jobHunterMapper.selectJobHunterByUsernameAndPassword(username,password);
        if (jobHunter1!=null){
            JobHunter jobHunter=new JobHunter();
            jobHunter.setId(jobHunter1.getId());
            jobHunter.setUsername(jobHunter1.getUsername());
            jobHunter.setPassword(jobHunter1.getPassword());
            String token=JwtUtils.createJWT(String.valueOf(jobHunter.getId()),jobHunter.getUsername(),jobHunter.toString()+new Date(),24*60*60000);
            //System.out.println(token);
            jobHunter1.setToken(token);
            JwtUtils.onlineJobHunters.put(jobHunter1.getId(),token);
        }
        return jobHunter1;

    }
    @Override
    public Boolean addJobHunter(String username, String password,String phone) {
        try{
           return  jobHunterMapper.insertJobHunter(username,password,username+"@lieying.cn",phone,username,"男",new Date(),"imgs/user.png","","interest","address")==1;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public Boolean modifyJobHunter(JobHunter jobHunter) {

        try {
            return jobHunterMapper.updateJobHunter(jobHunter.getId(),
                    jobHunter.getUsername(),jobHunter.getPassword(),
                    jobHunter.getEmail(),jobHunter.getPhone(),
                    jobHunter.getName(),jobHunter.getSex(),jobHunter.getBirthday(),
                    jobHunter.getPhoto(),
                    jobHunter.getEducation(),
                    jobHunter.getInterest(),
                    jobHunter.getAddress())==1;
        } catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
