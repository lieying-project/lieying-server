package org.lieying.web.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.junit.jupiter.api.Test;
import org.lieying.bean.Chat;
import org.lieying.bean.JobHunter;
import org.lieying.bean.Recruiter;
import org.lieying.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Api(value = "聊天信息接口",tags = "聊天信息")
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;
    /*
    * 根据求职者编号和招聘者编号查询聊天信息
    * */
    @ApiOperation(value = "根据求职者编号和招聘者编号查询聊天信息",notes = "根据求职者编号和招聘者编号查询聊天信息")
    @RequestMapping("/{jobHunterId}/{recruiterId}")
    public String getChatsByJobHunterIdAndRecruiterId(@PathVariable int jobHunterId,
                                                      @PathVariable int recruiterId){
        List<Chat> chats=chatService.findChatsByJobHunterIdAndRecruiterId(jobHunterId,recruiterId);
        for (Chat chat:chats){
            Chat chat1=new Chat();
            chat1.setSentDate(chat.getSentDate());
            chat1.setJobHunter(chat.getJobHunter());
            chat1.setRecruiter(chat.getRecruiter());
            chat1.setSenderFlag(chat.getSenderFlag());
            chat1.setSentDate(chat.getSentDate());
            chat=chat1;

        }
        System.out.println(chats);
        return JSON.toJSONString(chats);
    }

    /*
    * 根据求职者编号查询聊天信息
    * */
    @ApiOperation(value = "根据求职者编号查询聊天信息",notes = "根据求职者编号查询聊天信息")
    @RequestMapping(value="/jobHunter/{jobHunterId}", produces = "text/plain;charset=UTF-8")
    public String getChatsByJobHunterId(@PathVariable int jobHunterId){
        List<Chat> chats=chatService.findChatsByJobHunterId(jobHunterId);
        for (Chat chat:chats){
            chat.getRecruiter();
            chat.getJobHunter();
        }
        System.out.println(chats);
        return JSON.toJSONString(chats);
    }

    /*
     * 根据招聘者编号查询聊天信息
     * */
    @ApiOperation(value = "根据招聘者编号查询聊天信息",notes = "根据招聘者编号查询聊天信息")
    @RequestMapping(value="/recruiter/{recruiterId}",produces = "text/plain;charset=UTF-8")
    public String getChatsByRecruiterId(@PathVariable int recruiterId){
        List<Chat> chats=chatService.findChatsByRecruiterId(recruiterId);
        for (Chat chat:chats){
            chat.getRecruiter();
            chat.getJobHunter();
        }
        System.out.println(chats);
        return JSON.toJSONString(chats);
    }

    /*
    * 根据求职者编号查询招聘者信息
    * */
    @ApiOperation(value = "根据求职者编号查询招聘者信息",notes = "根据求职者编号查询招聘者信息")
    @RequestMapping(value="/jobHunter/{jobHunterId}/recruiters", produces = "text/plain;charset=UTF-8")
    public String getChatRecruitersByJobHunterId(@PathVariable int jobHunterId){
        List<Chat> chats=chatService.findChatsByJobHunterId(jobHunterId);
        List<Recruiter> recruiters=new ArrayList<>();
        Set<Integer> ids=new HashSet<>();
        for (Chat chat:chats){
            if (ids.add(chat.getRecruiter().getId())){
                recruiters.add(chat.getRecruiter());
            }
        }
        System.out.println(recruiters);
        return JSON.toJSONString(recruiters);
    }

    /*
     * 根据招聘者编号查询求职者信息
     * */
    @ApiOperation(value = "根据招聘者编号查询求职者信息",notes = "根据招聘者编号查询求职者信息")
    @RequestMapping(value="/recruiter/{recruiterId}/jobHunters",produces = "text/plain;charset=UTF-8")
    public String getChatJobHuntersByRecruiterId(@PathVariable int recruiterId){
        List<Chat> chats=chatService.findChatsByRecruiterId(recruiterId);
        List<JobHunter> jobHunters=new ArrayList<>();
        Set<Integer> ids=new HashSet<>();
        for (Chat chat:chats){
            if (ids.add(chat.getJobHunter().getId())){
                jobHunters.add(chat.getJobHunter());

            }
        }
        System.out.println(jobHunters);
        return JSON.toJSONString(jobHunters);
    }

    /*
    * 保存聊天信息
    * */
    @ApiOperation(value = "保存聊天信息",notes = "保存聊天信息")
    @RequestMapping(value="/save",produces = "text/plain;charset=UTF-8")
    public String saveChat(@RequestBody Chat chat){
        return JSON.toJSONString(chatService.addChat(chat));
    }
}
