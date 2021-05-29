package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lieying.bean.Administrator;
import org.lieying.bean.Resume;
import org.lieying.core.CommonResult;
import org.lieying.core.ResultGenerator;
import org.lieying.service.AdministratorService;
import org.lieying.service.JobHunterReportService;
import org.lieying.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

///@CrossOrigin
@Api(value = "管理员信息接口", tags = "管理员信息")
@RestController
@RequestMapping("/admin")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private ResumeService resumeService;


    @Autowired
    private JobHunterReportService jobHunterReportService;

    /*
     *  管理员登录
     *  @param administrator 管理员 (账号、密码)
     */
    @ApiOperation(value = "管理员登录", notes = "管理员登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult adminLogin(@RequestBody Administrator administrator) {

        //System.out.println(administrator);
        Administrator administrator1 = administratorService.queryAdministratorByUsernameAndPassword(administrator.getUsername(), administrator.getPassword());

        return ResultGenerator.genSuccessfulResult(administrator1);
    }


    /*>
     *   管理员详情
     *   @param administratorId 管理员id
     */
    @ApiOperation(value = "管理员详情", notes = "管理员详情")
    @GetMapping(value = "/{administratorId}")
    public CommonResult getAdministratorById(@PathVariable int administratorId) {
        return ResultGenerator.genSuccessfulResult(administratorService.queryDetailAdministratorById(administratorId));
    }


    /* @RequestMapping(value = "/reports",produces = "text/plain;charset=UTF-8")
     public String getAllJobHunterReports(){
         return JSON.toJSONString(jobHunterReportService.queryAllJobHunterReports());
     }*/
    /*
     * 根据条件查询求职者举报信息
     * */
    @ApiOperation(value = "根据条件查询求职者举报信息", notes = "根据条件查询求职者举报信息")
    @GetMapping(value = "/reports")
    public CommonResult getJobHunterReportsByCriteria(@RequestParam(value = "positionName", required = false) String positionName,
                                                @RequestParam(value = "jobHunterName", required = false) String jobHunterName,

                                                @RequestParam(value = "reportReason", required = false) String reason,
                                                @RequestParam(value = "reportState", required = false) String state) {

        return ResultGenerator.genSuccessfulResult(jobHunterReportService.queryJobHunterReportsByCriteria(positionName, jobHunterName, reason, state));
    }

    /*
     * 更新简历状态
     * */
    @ApiOperation(value = "更新简历状态", notes = "更新简历状态")
    @PutMapping(value = "/resume/update")
    public CommonResult updateResumeState(@RequestBody Resume resume) {
        return ResultGenerator.genEditSuccessfulResult(resumeService.modifyResume(resume));
    }


}
