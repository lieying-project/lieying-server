package org.lieying.service.impl;

import org.lieying.bean.Recruiter;
import org.lieying.dao.RecruiterMapper;
import org.lieying.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
@Service
public class RecruiterServiceImpl  implements RecruiterService {
    @Autowired
    private RecruiterMapper recruiterMapper;
    @Override
    public Recruiter queryRecruiterByUsernameAndPassword(String username, String password) {
        return recruiterMapper.selectRecruiterByUsernameAndPassword(username, password);
    }
    @Override
    public Recruiter queryDetailRecruiterById(int recruiterId) {
        return recruiterMapper.selectDetailRecruiterById(recruiterId);
    }

    @Override
    public Boolean addRecruiter(String username,  String password,String phone) {
        try {
            return recruiterMapper.insertRecruiter(username,"name", "intro",password,"position",phone,"default.jpg")==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
