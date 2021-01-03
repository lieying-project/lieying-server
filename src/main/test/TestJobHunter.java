import org.junit.jupiter.api.Test;
import org.lieying.bean.JobHunter;

import java.util.HashSet;
import java.util.Set;

public class TestJobHunter {


    @Test
    public void test1(){
//        JobHunter jobHunter=new JobHunter();
//        jobHunter.setId(1);
//        JobHunter jobHunter1=new JobHunter();
//        jobHunter.setId(1);
//
//        Set<JobHunter> jobHunters=new HashSet<>();
//
//        System.out.println(jobHunter.equals(jobHunter1));
//        jobHunters.add(jobHunter1);
//        jobHunters.add(jobHunter);
//        System.out.println(jobHunters.size());
        Integer integer=new Integer(1);
        Integer integer1=new Integer(1);
        Set<Integer> integers=new HashSet<>();
        integers.add(integer);
        System.out.println(integers.add(integer1));
        System.out.println(integers.size());
    }
}
