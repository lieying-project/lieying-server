package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.lieying.bean.Recruiter;
import org.lieying.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//@CrossOrigin
@RestController
@RequestMapping("/recruiter")
public class RecruiterController {
    @Autowired
    private RecruiterService recruiterService;

    /*
     *   招聘者登录
     *   @param  recruiter  招聘者(账号、密码)
     */
    @PostMapping(value = "/login", produces = "text/plain;charset=UTF-8")
    public String login(@RequestBody Recruiter recruiter) {
        return JSON.toJSONString(recruiterService.queryRecruiterByUsernameAndPassword(recruiter.getUsername(), recruiter.getPassword()));
    }
    @PostMapping(value = "/register", produces = "text/plain;charset=UTF-8")
    public String recruiterRegister(@RequestBody Recruiter recruiter){
        return JSON.toJSONString(recruiterService.addRecruiter(recruiter.getUsername(),recruiter.getPassword(),recruiter.getPhone()));

    }

    @RequestMapping(value = "/{recruiterId}", produces = "text/plain;charset=UTF-8")
    public String findById(@PathVariable("recruiterId") int recruiterId) {
        return JSON.toJSONString(recruiterService.queryDetailRecruiterById(recruiterId));
    }


}
