package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;

import org.lieying.bean.*;
import org.lieying.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*
    * 添加简历
    * */
    @PostMapping(value = "/resume/add", produces = "text/plain;charset=UTF-8")
    public String addResume(@RequestBody Resume resume){
        return JSON.toJSONString(resumeService.addResume(resume));
    }

    /*
    * 更新简历
    * */
    @PostMapping(value = "/resume/update",produces = "text/plain;charset=UTF-8")
    public String updateResume(@RequestBody Resume resume){
        return JSON.toJSONString(resumeService.modifyResume(resume));
    }
    /*
    * 添加志愿经历
    * */
    @PostMapping(value = "/resume/volunteer/save", produces = "application/plain;charset=UTF-8")
    public String addVolunteerExperience(@RequestBody VolunteerExperience volunteerExperience){
        return JSON.toJSONString(volunteerExperienceService.addVolunteerExperience(volunteerExperience));
    }
    /*
     * 更新志愿经历
     * */
    @PostMapping(value = "/resume/volunteer/update", produces = "application/plain;charset=UTF-8")
    public String updateVolunteerExperience(@RequestBody VolunteerExperience volunteerExperience){
        return JSON.toJSONString(volunteerExperienceService.modifyVolunteerExperience(volunteerExperience));
    }
    /*
     * 添加项目经历
     * */
    @PostMapping(value = "/resume/project/save", produces = "application/plain;charset=UTF-8")
    public String addProjectExperience(@RequestBody ProjectExperience projectExperience){
        return JSON.toJSONString(projectExperienceService.addProjectExperience(projectExperience));
    }
    /*
     * 更新项目经历
     * */
    @PostMapping(value = "/resume/project/update", produces = "application/plain;charset=UTF-8")
    public String updateProjectExperience(@RequestBody ProjectExperience projectExperience){
        return JSON.toJSONString(projectExperienceService.modifyProjectExperience(projectExperience));
    }
    /*
     * 添加  实习经历
     * */
    @PostMapping(value = "/resume/internship/save", produces = "application/plain;charset=UTF-8")
    public String addInternshipExperience(@RequestBody InternshipExperience internshipExperience){
        return JSON.toJSONString(internshipExperienceService.addInternshipExperience(internshipExperience));
    }
    /*
    * 更新实习经历
    * */
    @PostMapping(value = "/resume/internship/update", produces = "application/plain;charset=UTF-8")
    public String updateInternshipExperience(@RequestBody InternshipExperience internshipExperience){
        return JSON.toJSONString(internshipExperienceService.modifyInternshipExperience(internshipExperience));
    }

    /*
     * 添加  资格证书
     * */
    @PostMapping(value = "/resume/credential/save", produces = "application/plain;charset=UTF-8")
    public String addCredential(@RequestBody Credential credential){
        return JSON.toJSONString(credentialService.addCredential(credential));
    }
    /*
     * 更新 资格证书
     * */
    @PostMapping(value = "/resume/credential/update", produces = "application/plain;charset=UTF-8")
    public String updateCredential(@RequestBody Credential credential){
        return JSON.toJSONString(credentialService.modifyCredential(credential));
    }
    /*
     * 添加  教育经历
     * */
    @PostMapping(value = "/resume/education/save", produces = "application/plain;charset=UTF-8")
    public String saveEducationExperience(@RequestBody EducationExperience educationExperience){
        return JSON.toJSONString(educationExperienceService.addEducationExperience(educationExperience));
    }
    /*
     * 更新 教育经历
     * */
    @PostMapping(value = "/resume/education/update", produces = "application/plain;charset=UTF-8")
    public String updateEducationExperience(@RequestBody EducationExperience educationExperience){
        return JSON.toJSONString(educationExperienceService.updateEducationExperience(educationExperience));
    }


    /*
    * 添加社交主页
    * */
    @PostMapping(value = "/resume/socialHomepage/save", produces = "application/plain;charset=UTF-8")
    public String saveSocialHomepage(@RequestBody SocialHomepage socialHomepage){
        return JSON.toJSONString(socialHomepageService.addSocialhomepage(socialHomepage));
    }

    /*
    * 更新社交主页
    * */
    @PostMapping(value = "/resume/socialHomepage/update", produces = "application/plain;charset=UTF-8")
    public String updateSocialHomepage(@RequestBody SocialHomepage socialHomepage){
        return JSON.toJSONString(socialHomepageService.modifySocialhomepage(socialHomepage));
    }

    /*
    * 求职者登录
    * */
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

    /*
    * 求职者注册
    * */
    @PostMapping(value = "/register", produces = "text/plain;charset=UTF-8")
    public String jobHunterRegister(@RequestBody JobHunter jobHunter){
        return JSON.toJSONString(jobHunterService.addJobHunter(jobHunter.getUsername(),jobHunter.getPassword(),jobHunter.getPhone()));
    }

    /*
     * 更新求职者
     * */
    @PostMapping(value = "/update",produces = "text/plain;charset=UTF-8")
    public String updateJobHunter(@RequestBody JobHunter jobHunter){
        return JSON.toJSONString(jobHunterService.modifyJobHunter(jobHunter));
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

    /*
    * 保存求职者举报信息
    * */
    @PostMapping(value = "/report/save", produces = "text/plain;charset=UTF-8")
    public String saveJobHunterReport(@RequestBody JobHunterReport jobHunterReport) {
        return JSON.toJSONString(jobHunterReportService.addJobHunterReport(jobHunterReport));
    }

    /*
    * 更新举报信息
    * */
    @PostMapping(value = "/report/update", produces = "text/plain;charset=UTF-8")
    public String updateJobHunterReport(@RequestBody JobHunterReport jobHunterReport) {
        //System.out.println(jobHunterReport);
        return JSON.toJSONString(jobHunterReportService.updateJobHunterReport(jobHunterReport));
    }
}
