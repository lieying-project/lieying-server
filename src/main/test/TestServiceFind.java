import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lieying.service.JobHunterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestServiceFind {
    private ApplicationContext applicationContext;
    private JobHunterService jobHunterService;
    @BeforeEach
    void setUp() {
        applicationContext=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        jobHunterService=(JobHunterService)applicationContext.getBean("jobHunterServiceImpl");
    }
    @Test
    public void testQueryJobHunterByUsernameAndPassword(){
        System.out.println(jobHunterService.queryJobHunterByUsernameAndPassword("zhangsan","aaaaa"));

    }
}
