import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import org.lieying.web.controller.WebSocket;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class TestSpringMybatis {


    @Test
    public void test(){

        ApplicationContext applicationContext=new
                FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        SqlSession sqlSession=sqlSessionFactory.openSession();
//        PositionMapper positionMapper=sqlSession.getMapper(PositionMapper.class);
//        List<Position> positions =positionMapper.selectPositionsByCriteria("软",null,null,null,null,null,null,null,null);
//        System.out.println(positions);

//        sqlSession.close();


//        ChatService chatService= (ChatService) applicationContext.getBean("chatService");
//        List<Chat> chats=chatService.findChatsByJobHunterIdAndRecruiterId(1,1);
//        System.out.println(chats);
//        System.out.println(chats.get(0).getJobHunter());
//        System.out.println(chats.get(0).getRecruiter());

        WebSocket webSocket=(WebSocket)applicationContext.getBean("webSocket");
        System.out.println(webSocket);

       //System.out.println(webSocket.chatService.findChatsByJobHunterIdAndRecruiterId(1,1));
    }

}
