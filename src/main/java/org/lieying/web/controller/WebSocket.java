package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import org.lieying.bean.Chat;
import org.lieying.bean.JobHunter;
import org.lieying.bean.Recruiter;
import org.lieying.service.ChatService;

import org.lieying.service.JobHunterService;
import org.lieying.service.RecruiterService;
import org.lieying.service.impl.ChatServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
//@CrossOrigin
@Api(value = "WebSocket接口")
@RestController
@ServerEndpoint(value = "/websocket/{userId}/{userType}")
public class WebSocket {
    private static ChatService chatService;

    @Autowired
    public  void setChatService(ChatServiceImpl chatServiceImpl) {
        WebSocket.chatService = chatServiceImpl;
    }
    private  int userId;
    private  String userType;
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private static ConcurrentHashMap<String, WebSocket> websocketMap = new ConcurrentHashMap<>();
    private Logger logger = LoggerFactory.getLogger(WebSocket.class);
    //连接时执行
    @OnOpen
    public void onOpen(@PathParam("userId") int userId, @PathParam("userType") String userType,Session session) throws IOException {
        this.userId = userId;
        this.userType=userType;
        this.session = session;
        websocketMap.put(userType+userId, this);
        List<Chat> chats=WebSocket.chatService.findChatsByJobHunterId(userId);
        List<Chat> chats1=new ArrayList<>();
        for (Chat chat:chats){
            Chat chat1=new Chat();
            chat1.setSentDate(chat.getSentDate());
            JobHunter jobHunter=new JobHunter();
            jobHunter.setPhoto(chat.getJobHunter().getPhoto());
            jobHunter.setId(chat.getJobHunter().getId());
            chat1.setJobHunter(jobHunter);
            Recruiter recruiter=new Recruiter();
            recruiter.setId(chat.getRecruiter().getId());
            recruiter.setPhoto(chat.getRecruiter().getPhoto());
            chat1.setRecruiter(recruiter);
            chat1.setSenderFlag(chat.getSenderFlag());
            chat1.setSentDate(chat.getSentDate());
            chat1.setContent(chat.getContent());
            chats1.add(chat1);
        }
        session.getBasicRemote().sendText(JSON.toJSONString(chats1));
        logger.debug("{} {}连接", userType,userId);
        logger.debug("当前在线人数:{}", websocketMap.size());
    }
    //关闭时执行
    @OnClose
    public void onClose() {
        websocketMap.remove(userType+userId);
        logger.debug("{} {}退出", userType,userId);
        logger.debug("当前在线人数:{}", websocketMap.size());
    }
    //收到消息时执行
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        Chat chat = JSON.parseObject(message, Chat.class);
        System.out.println("chat:");
        System.out.println(chat);
        chat.setSentDate(new Date());
        chatService.addChat(chat);
        System.out.println(chat.getId());
        System.out.println(chat);
        String sendMessage=JSON.toJSONString(chat);
        for(String key:websocketMap.keySet()){
            if (key.equals(userType+userId)){
                if (userType.equals("jobHunter")){
                    WebSocket w= websocketMap.get("recruiter"+chat.getRecruiter().getId());
                    if (w!=null){
                        w.sendMessage(sendMessage);
                    }

                } else if (userType.equals("recruiter")){
                    WebSocket w= websocketMap.get("jobHunter"+chat.getJobHunter().getId());
                    if (w!=null){
                        w.sendMessage(sendMessage);
                    }
                }
                session.getBasicRemote().sendText(sendMessage);
                logger.debug("{} {}发送了消息", userType,userId);
                logger.debug("当前在线人数:{}", websocketMap.size());
                break;
            }
        }

    }
    //连接错误时执行
    @OnError
    public void onError(Session session, Throwable error) {
        logger.debug("用户{}的连接发送错误", userId);
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }



}
