package org.lieying;

import org.lieying.service.ChatService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import java.io.IOException;

public class TestSpring {
    public static void main(String[] args) throws IOException {


        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("E:\\project\\java\\lieying\\src\\main\\resources\\applicationContext.xml");


        ChatService chatService= (ChatService) applicationContext.getBean("chatService");
        System.out.println(chatService.findChatsByJobHunterIdAndRecruiterId(1,1));


    }
}
