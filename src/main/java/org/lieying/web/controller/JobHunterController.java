package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.lieying.bean.JobHunter;
import org.lieying.bean.JobHunterReport;
import org.lieying.bean.Resume;
import org.lieying.service.JobHunterReportService;
import org.lieying.service.JobHunterService;
import org.lieying.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@CrossOrigin
@RestController
@RequestMapping("/jobHunter")
public class JobHunterController {
    @Autowired
    private JobHunterService jobHunterService;
    @Autowired
    private JobHunterReportService jobHunterReportService;
    @Autowired
    private ResumeService resumeService;

    /*
     *   查询所有求职者信息
     */
    @RequestMapping(value = "/all", produces = "text/plain;charset=UTF-8")
    public String allJobHunter() {
        return JSON.toJSONString(jobHunterService.queryAllJobHunter());
    }

    /*
     *   查询单个求职者
     *   @param jobHunterId  求职者id
     *
     */
    @RequestMapping(value = "/{jobHunterId}", produces = "text/plain;charset=UTF-8")
    public String getJobHunterById(@PathVariable int jobHunterId) {
        return JSON.toJSONString(jobHunterService.queryDetailJobHunterById(jobHunterId));
    }

    /*
     *   求职者所有简历
     *   @param  jobhunterId   简历id
     */
    @RequestMapping(value = "/{jobHunterId}/resumes", produces = "text/plain;charset=UTF-8")
    public String getJobHunterResumesByJobHunterId(@PathVariable int jobHunterId) {
        return JSON.toJSONString(resumeService.queryResumesByJobHunterId(jobHunterId));
    }

    /*
     *   简历详情
     *   @param  resumeId  简历id
     */
    @RequestMapping(value = "/resume/{resumeId}", produces = "text/plain;charset=UTF-8")
    public String getResumeById(@PathVariable int resumeId) {
        return JSON.toJSONString(resumeService.queryResumeById(resumeId));
    }

    @PostMapping(value = "/resume/update", produces = "text/plain;charset=UTF-8")
    public String updateResumeState(@RequestBody Resume resume) {

        return JSON.toJSONString(resumeService.modifyResumeState(resume));
    }

    @PostMapping(value = "/login", produces = "application/plain;charset=UTF-8")
    public String jobHunterLogin(@RequestBody JobHunter jobHunter, HttpServletResponse response) {
        System.out.println(jobHunter);
//        String token = request.getHeader("token");
//        jobHunter.setToken(token);
        JobHunter jobHunter1 = jobHunterService.queryJobHunterByUsernameAndPassword(
                jobHunter.getUsername(), jobHunter.getPassword());

        System.out.println(jobHunter1 == null);
        if (jobHunter1 == null) {
            return null;
        }
        String token = jobHunter1.getToken();
        System.out.println(token);
        //System.out.println(token.length());
        response.setHeader("Access-Control-Expose-Headers", "token");
        response.setHeader("token", token);
        return JSON.toJSONString(jobHunter1);
    }
    @PostMapping(value = "/register", produces = "text/plain;charset=UTF-8")
    public String jobHunterRegister(@RequestBody JobHunter jobHunter){
        return JSON.toJSONString(jobHunterService.addJobHunter(jobHunter.getUsername(),jobHunter.getPassword(),jobHunter.getPhone()));
    }
    /*
     *  根据求职者id和职位id获取举报信息
     *  @param  jobHunterId  求职者id
     *  @param  positionId  职位id
     */
    @RequestMapping(value = "/report/{jobHunterId}/{positionId}", produces = "text/plain;charset=UTF-8")
    public String getJobHunterReportByJobHunterIdAndPositionId(
            @PathVariable int jobHunterId, @PathVariable int positionId) {
        return JSON.toJSONString(jobHunterReportService.queryJobHunterReportByJobHunterIdAndPositionId(jobHunterId, positionId));
    }

    @PostMapping(value = "/report/save", produces = "text/plain;charset=UTF-8")
    public String saveJobHunterReport(@RequestBody JobHunterReport jobHunterReport) {
        return JSON.toJSONString(jobHunterReportService.addJobHunterReport(jobHunterReport));
    }

    //更新举报信息
    @PostMapping(value = "/report/update", produces = "text/plain;charset=UTF-8")
    public String updateJobHunterReport(@RequestBody JobHunterReport jobHunterReport) {
        //System.out.println(jobHunterReport);
        return JSON.toJSONString(jobHunterReportService.updateJobHunterReport(jobHunterReport));
    }


}
