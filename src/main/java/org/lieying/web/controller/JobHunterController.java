package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.lieying.bean.*;
import org.lieying.core.CommonResult;
import org.lieying.core.ResultCode;
import org.lieying.core.ResultGenerator;
import org.lieying.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(value = "求职者信息接口", tags = "求职者")
@RestController
@RequestMapping("/jobHunter")
public class JobHunterController {
    @Autowired
    private JobHunterService jobHunterService;

    @Autowired
    private JobHunterReportService jobHunterReportService;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private VolunteerExperienceService volunteerExperienceService;

    @Autowired
    private ProjectExperienceService projectExperienceService;

    @Autowired
    private CredentialService credentialService;

    @Autowired
    private EducationExperienceService educationExperienceService;

    @Autowired
    private InternshipExperienceService internshipExperienceService;

    @Autowired
    private SocialHomepageService socialHomepageService;


    /*
     *   查询所有求职者信息
     */
    @ApiOperation(value = "查询所有求职者", notes = "查询数据库中所有的求职者信息")
    @GetMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public CommonResult allJobHunter() {
        return ResultGenerator.genSuccessfulResult(jobHunterService.queryAllJobHunter());

    }

    /*
     *   查询单个求职者
     *   @param jobHunterId  求职者id
     *
     */
    @ApiOperation(value = "查询单个求职者", notes = "根据求职者编号查询单个求职者信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobHunterId", value = "求职者编号", required = true, paramType = "query", dataType = "Integer"),
    })
    @GetMapping(value = "/{jobHunterId}")
    public CommonResult getJobHunterById(@PathVariable int jobHunterId) {
        return ResultGenerator.genSuccessfulResult(jobHunterService.queryDetailJobHunterById(jobHunterId));
    }

    /*
     *   求职者所有简历
     *   @param  jobhunterId   简历id
     */
    @ApiOperation(value = "查询求职者所有简历信息", notes = "根据求职者编号查询所有简历信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobHunterId", value = "求职者编号", required = true, paramType = "query", dataType = "Integer"),
    })
    @GetMapping(value = "/{jobHunterId}/resumes")
    public CommonResult getJobHunterResumesByJobHunterId(@PathVariable int jobHunterId) {
        return ResultGenerator.genSuccessfulResult(resumeService.queryResumesByJobHunterId(jobHunterId));
    }

    /*
     *   简历详情
     *   @param  resumeId  简历id
     */
    @ApiOperation(value = "查询单个简历信息", notes = "根据简历编号查询单个简历信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resumeId", value = "简历编号", required = true, paramType = "query", dataType = "Integer"),
    })
    @GetMapping(value = "/resume/{resumeId}")
    public CommonResult getResumeById(@PathVariable int resumeId) {
        return ResultGenerator.genSuccessfulResult(resumeService.queryResumeById(resumeId));
    }

    /*
     * 添加简历
     * */
    @ApiOperation(value = "添加简历", notes = "查询数据库中单个简历信息")
    @PostMapping(value = "/resume/save")
    public CommonResult addResume(@RequestBody Resume resume) {
        return ResultGenerator.genEditSuccessfulResult(resumeService.addResume(resume));
    }

    /*
     * 更新简历
     * */
    @ApiOperation(value = "更新简历", notes = "更新简历")
    @PostMapping(value = "/resume/update")
    public CommonResult updateResume(@RequestBody Resume resume) {
        return ResultGenerator.genEditSuccessfulResult(resumeService.modifyResume(resume));
    }

    /*
     * 添加志愿经历
     * */
    @ApiOperation(value = "添加志愿经历", notes = "添加志愿经历")
    @PostMapping(value = "/resume/volunteer/save")
    public CommonResult addVolunteerExperience(@RequestBody VolunteerExperience volunteerExperience) {
        return ResultGenerator.genEditSuccessfulResult(volunteerExperienceService.addVolunteerExperience(volunteerExperience));
    }

    /*
     * 更新志愿经历
     * */
    @ApiOperation(value = "更新志愿经历", notes = "更新志愿经历")
    @PostMapping(value = "/resume/volunteer/update")
    public CommonResult updateVolunteerExperience(@RequestBody VolunteerExperience volunteerExperience) {
        return ResultGenerator.genEditSuccessfulResult(volunteerExperienceService.modifyVolunteerExperience(volunteerExperience));
    }

    /*
     * 添加项目经历
     * */
    @ApiOperation(value = "添加项目经历", notes = "添加项目经历")
    @PostMapping(value = "/resume/project/save")
    public CommonResult addProjectExperience(@RequestBody ProjectExperience projectExperience) {
        return ResultGenerator.genEditSuccessfulResult(projectExperienceService.addProjectExperience(projectExperience));
    }

    /*
     * 更新项目经历
     * */
    @ApiOperation(value = "更新项目经历", notes = "更新项目经历")
    @PostMapping(value = "/resume/project/update")
    public CommonResult updateProjectExperience(@RequestBody ProjectExperience projectExperience) {
        return ResultGenerator.genEditSuccessfulResult(projectExperienceService.modifyProjectExperience(projectExperience));
    }

    /*
     * 添加实习经历
     * */
    @ApiOperation(value = "添加实习经历", notes = "添加实习经历")
    @PostMapping(value = "/resume/internship/save")
    public CommonResult addInternshipExperience(@RequestBody InternshipExperience internshipExperience) {
        return  ResultGenerator.genEditSuccessfulResult(internshipExperienceService.addInternshipExperience(internshipExperience));
    }

    /*
     * 更新实习经历
     * */
    @ApiOperation(value = "更新实习经历", notes = "更新实习经历")
    @PostMapping(value = "/resume/internship/update")
    public CommonResult updateInternshipExperience(@RequestBody InternshipExperience internshipExperience) {
        return  ResultGenerator.genEditSuccessfulResult(internshipExperienceService.modifyInternshipExperience(internshipExperience));
    }

    /*
     * 添加资格证书
     * */
    @ApiOperation(value = "添加资格证书", notes = "添加资格证书")
    @PostMapping(value = "/resume/credential/save")
    public CommonResult addCredential(@RequestBody Credential credential) {
        return  ResultGenerator.genEditSuccessfulResult(credentialService.addCredential(credential));
    }

    /*
     * 更新资格证书
     * */
    @ApiOperation(value = "更新资格证书", notes = "更新资格证书")
    @PostMapping(value = "/resume/credential/update")
    public CommonResult updateCredential(@RequestBody Credential credential) {
        return  ResultGenerator.genEditSuccessfulResult(credentialService.modifyCredential(credential));
    }

    /*
     * 添加教育经历
     * */
    @ApiOperation(value = "添加教育经历", notes = "添加教育经历")
    @PostMapping(value = "/resume/education/save")
    public CommonResult saveEducationExperience(@RequestBody EducationExperience educationExperience) {
        System.out.println(educationExperience);
        return  ResultGenerator.genEditSuccessfulResult(educationExperienceService.addEducationExperience(educationExperience));
    }

    /*
     * 更新教育经历
     * */
    @ApiOperation(value = "更新教育经历", notes = "更新教育经历")
    @PutMapping(value = "/resume/education/update")
    public CommonResult updateEducationExperience(@RequestBody EducationExperience educationExperience) {
        return  ResultGenerator.genEditSuccessfulResult(educationExperienceService.updateEducationExperience(educationExperience));
    }


    /*
     * 添加社交主页
     * */
    @ApiOperation(value = "添加社交主页", notes = "添加社交主页")
    @PostMapping(value = "/resume/socialHomepage/save")
    public CommonResult saveSocialHomepage(@RequestBody SocialHomepage socialHomepage) {
        return  ResultGenerator.genEditSuccessfulResult(socialHomepageService.addSocialhomepage(socialHomepage));
    }

    /*
     * 更新社交主页
     * */
    @ApiOperation(value = "更新社交主页", notes = "更新社交主页")
    @PostMapping(value = "/resume/socialHomepage/update")
    public CommonResult updateSocialHomepage(@RequestBody SocialHomepage socialHomepage) {
        return  ResultGenerator.genEditSuccessfulResult(socialHomepageService.modifySocialhomepage(socialHomepage));
    }

    /*
     * 求职者登录
     * */
    @ApiOperation(value = "求职者登录", notes = "求职者登录")
    @PostMapping(value = "/login")
    public CommonResult jobHunterLogin(@RequestBody JobHunter jobHunter, HttpServletResponse response) {
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
        return ResultGenerator.genSuccessfulResult(jobHunter1);
    }

    /*
     * 求职者注册
     * */
    @ApiOperation(value = "求职者注册", notes = "求职者注册")
    @PostMapping(value = "/register")
    public CommonResult jobHunterRegister(@RequestBody JobHunter jobHunter) {
        return ResultGenerator.genEditSuccessfulResult(jobHunterService.addJobHunter(jobHunter.getUsername(), jobHunter.getPassword(), jobHunter.getPhone()));
    }

    /*
     * 更新求职者
     * */
    @ApiOperation(value = "更新求职者", notes = "更新求职者")
    @PutMapping(value = "/update")
    public CommonResult updateJobHunter(@RequestBody JobHunter jobHunter) {
        return ResultGenerator.genEditSuccessfulResult(jobHunterService.modifyJobHunter(jobHunter));
    }

    /*
     *  根据求职者id和职位id获取举报信息
     *  @param  jobHunterId  求职者id
     *  @param  positionId  职位id
     */
    @ApiOperation(value = "根据求职者id和职位id获取举报信息", notes = "根据求职者id和职位id获取举报信息")
    @GetMapping(value = "/report/{jobHunterId}/{positionId}")
    public CommonResult getJobHunterReportByJobHunterIdAndPositionId(
            @PathVariable int jobHunterId, @PathVariable int positionId) {
        return ResultGenerator.genSuccessfulResult(jobHunterReportService.queryJobHunterReportByJobHunterIdAndPositionId(jobHunterId, positionId));
    }

    /*
     * 保存求职者举报信息
     * */
    @ApiOperation(value = "保存求职者举报信息", notes = "保存求职者举报信息")
    @PostMapping(value = "/report/save")
    public CommonResult saveJobHunterReport(@RequestBody JobHunterReport jobHunterReport) {
        return ResultGenerator.genEditSuccessfulResult(jobHunterReportService.addJobHunterReport(jobHunterReport));
    }

    /*
     * 更新举报信息
     * */
    @ApiOperation(value = "更新求职者举报信息", notes = "更新求职者举报信息")
    @PutMapping(value = "/report/update")
    public CommonResult updateJobHunterReport(@RequestBody JobHunterReport jobHunterReport) {
        //System.out.println(jobHunterReport);
        return ResultGenerator.genEditSuccessfulResult(jobHunterReportService.updateJobHunterReport(jobHunterReport));
    }


}
