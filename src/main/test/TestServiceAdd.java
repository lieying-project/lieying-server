import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lieying.bean.Administrator;
import org.lieying.bean.Information;
import org.lieying.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import java.util.Date;

public class TestServiceAdd {
    private ApplicationContext applicationContext;
    private ResumeService resumeService;
    private CredentialService credentialService;
    private InternshipExperienceService internshipExperienceService;
    private ProjectExperienceService projectExperienceService;
    private VolunteerExperienceService volunteerExperienceService;
    private JobHunterService jobHunterService;
    private RecruiterService recruiterService;
    private InformationService informationService;
    @BeforeEach
    void setUp() {
        applicationContext=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        resumeService=(ResumeService)applicationContext.getBean("resumeServiceImpl");
        credentialService=(CredentialService)applicationContext.getBean("credentialServiceImpl");
        internshipExperienceService=(InternshipExperienceService) applicationContext.getBean("internshipExperienceServiceImpl");
        projectExperienceService=(ProjectExperienceService) applicationContext.getBean("projectExperienceServiceImpl");
        volunteerExperienceService=(VolunteerExperienceService)applicationContext.getBean("volunteerExperienceServiceImpl");
        jobHunterService=(JobHunterService)applicationContext.getBean("jobHunterServiceImpl");
        recruiterService=(RecruiterService)applicationContext.getBean("recruiterServiceImpl");
        informationService=(InformationService)applicationContext.getBean("informationServiceImpl");
        System.out.println(resumeService);
        System.out.println(credentialService);
        System.out.println(internshipExperienceService);
        System.out.println(projectExperienceService);
        System.out.println(jobHunterService);
        System.out.println(recruiterService);
        System.out.println(volunteerExperienceService);
        System.out.println(informationService);
    }
    @Test
    public void testAddCredential(){
        System.out.println(credentialService.addCredential("证书4","photo1",1));
    }
    @Test
    public void testAddInternshipExperience(){
        System.out.println(internshipExperienceService.addInternshipExperience("company1","department1",
                "posicategory1","industry1","technolory1","positionName",
                new Date(),new Date(),"jobContent","jobPerformance",1));
    }

    @Test
    public void testAddProjectExperience(){
        System.out.println(projectExperienceService.addProjectExperience("name1","role1","url1",
                new Date(),new Date(),"desc","performance",1));
    }

    @Test
    public void testAddVolunteerExperience(){
        System.out.println(volunteerExperienceService.addVolunteerExperience("name","duaration",
                new Date(),new Date(),"desc",1));
    }
    @Test
    public void testAddJobHunter(){
        System.out.println(jobHunterService.addJobHunter("username1","password1","phone1"));
    }

    @Test
    public void testUpdateJobHunter(){
        System.out.println(jobHunterService.updateJobHunter(25,"25jobhunter","abc123456","25jobhunter@lieying.com",
                "18791223132","25jonbss","男",new Date(),"photo","博士后",
                "INERR","ADDRWE"));
    }

    @Test
    public void testAddRecruiter(){
        System.out.println(recruiterService.addRecruiter("username1","password1","photo"));
    }

    @Test
    public void testAddResume(){
        System.out.println(resumeService.addResume("name1","博士后",1,"advantage",
                "expectedCity","expectedPosition","salary","workaddress",
                "worjexperience","projecrexe","socialhomee","volunsse",
                "enff","rejectReason",new Date(),new Date(),new Date(),"state"));
    }
    @Test
    public void testDeleteResume(){
        System.out.println(resumeService.removeResume(5));
    }
    @Test
    public void updateResumeNameById(){
        System.out.println(resumeService.updateResumeNameById(1,"简历11"));
    }



    @Test
    public void testAddInformation(){
        Information information=new Information();
        information.setTitle("title1");
        information.setContent("content1");
        information.setCreatedTime(new Date());
        information.setType("type1");
        Administrator administrator=new Administrator();
        administrator.setId(1);
        information.setAdministrator(administrator);
        System.out.println(informationService.addInformation(information));
    }

}
