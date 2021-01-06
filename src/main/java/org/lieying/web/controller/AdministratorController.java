package org.lieying.web.controller;
import com.alibaba.fastjson.JSON;
import org.lieying.bean.Administrator;
import org.lieying.bean.Resume;
import org.lieying.service.AdministratorService;
import org.lieying.service.JobHunterReportService;
import org.lieying.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

///@CrossOrigin
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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String adminLogin(@RequestBody Administrator administrator)  {

        //System.out.println(administrator);
        Administrator administrator1=administratorService.queryAdministratorByUsernameAndPassword(administrator.getUsername(),administrator.getPassword());

        return JSON.toJSONString(administrator1);
    }


    /*>
    *   管理员详情
    *   @param administratorId 管理员id
    */
    @RequestMapping(value = "/{administratorId}",produces = "text/plain;charset=UTF-8")
    public String getAdministratorById(@PathVariable  int administratorId){
        return JSON.toJSONString(administratorService.queryDetailAdministratorById(administratorId));
    }


   /* @RequestMapping(value = "/reports",produces = "text/plain;charset=UTF-8")
    public String getAllJobHunterReports(){
        return JSON.toJSONString(jobHunterReportService.queryAllJobHunterReports());
    }*/
    @RequestMapping(value="/reports")
    public String getJobHunterReportsByCriteria(@RequestParam(value = "positionName", required = false) String positionName,
                                                @RequestParam(value = "jobHunterName", required = false) String jobHunterName,

                                                @RequestParam(value = "reportReason", required = false) String reason,
                                                @RequestParam(value = "reportState", required = false) String state){

        return JSON.toJSONString(jobHunterReportService.queryJobHunterReportsByCriteria(positionName,jobHunterName,reason,state));
    }



    /*
     * 更新简历状态
     * */
    @PostMapping(value = "/resume/update", produces = "text/plain;charset=UTF-8")
    public String updateResumeState(@RequestBody Resume resume) {
        return JSON.toJSONString(resumeService.modifyResume(resume));
    }




}
