package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lieying.bean.Recruiter;
import org.lieying.core.CommonResult;
import org.lieying.core.ResultGenerator;
import org.lieying.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//@CrossOrigin
@Api(value = "招聘者信息接口",tags = "招聘者信息")
@RestController
@RequestMapping("/recruiter")
public class RecruiterController {
    @Autowired
    private RecruiterService recruiterService;

    /*
     *   招聘者登录
     *   @param  recruiter  招聘者(账号、密码)
     */
    @ApiOperation(value = "招聘者登录",notes = "招聘者登录")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody Recruiter recruiter) {
        return ResultGenerator.genSuccessfulResult(recruiterService.queryRecruiterByUsernameAndPassword(recruiter.getUsername(), recruiter.getPassword()));
    }
    /*
    * 招聘者注册
    * */
    @ApiOperation(value = "招聘者注册",notes = "招聘者注册")
    @PostMapping(value = "/register")
    public CommonResult recruiterRegister(@RequestBody Recruiter recruiter){
        return ResultGenerator.genEditSuccessfulResult(recruiterService.addRecruiter(recruiter.getUsername(),recruiter.getPassword(),recruiter.getPhone()));

    }

    /*
    * 查询单个招聘者信息
    * */
    @ApiOperation(value = "查询单个招聘者信息",notes = "查询单个招聘者信息")
    @GetMapping(value = "/{recruiterId}")
    public CommonResult findById(@PathVariable("recruiterId") int recruiterId) {
        return ResultGenerator.genSuccessfulResult(recruiterService.queryDetailRecruiterById(recruiterId));
    }

}
