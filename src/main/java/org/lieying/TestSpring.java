package org.lieying;

import org.lieying.bean.PositionBrowse;
import org.lieying.service.ChatService;
import org.lieying.service.PositionBrowseService;
import org.lieying.service.PositionService;
import org.lieying.service.impl.PositionServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import java.io.IOException;

public class TestSpring {
    public static void main(String[] args) throws IOException {


        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("E:\\project\\java\\lieying\\src\\main\\resources\\applicationContext.xml");
//        ChatService chatService= (ChatService) applicationContext.getBean("chatService");
//        System.out.println(chatService.findChatsByJobHunterIdAndRecruiterId(1,1));
//        PositionBrowseService positionBrowseService= (PositionBrowseService) applicationContext.getBean("positionBrowseServiceImpl");
//        System.out.println(positionBrowseService.recomendPosition(16));

    }
}
