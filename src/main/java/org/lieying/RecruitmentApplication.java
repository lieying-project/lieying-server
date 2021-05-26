package org.lieying;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "org.lieying.dao")
public class RecruitmentApplication {

    public static void main(String[] args) {

        SpringApplication.run(RecruitmentApplication.class,args);
    }
}
