package org.lieying.service.impl;
import org.lieying.bean.Chat;
import org.lieying.dao.ChatMapper;
import org.lieying.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "chatService")
//@Scope("prototype")
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;
    @Override
    public boolean addChat(Chat chat) {
        return chatMapper.insertChat(chat.getJobHunter().getId(),chat.getRecruiter().getId(),
                chat.getContent(),chat.getSentDate(),chat.getSenderFlag())==1;
    }

    @Override
    public List<Chat> findChatsByJobHunterIdAndRecruiterId(int jobHunterId, int recruiterId) {
        return chatMapper.selectChatsByJobHunterIdAndRecruiterId(jobHunterId,recruiterId);
    }

    @Override
    public List<Chat> findChatsByJobHunterId(int jobHunterId) {
        return chatMapper.selectDetailChatsByJobHunterId(jobHunterId);
    }

    @Override
    public List<Chat> findChatsByRecruiterId(int recruiterId) {
        return chatMapper.selectDetailChatsByRecruiterId(recruiterId);
    }
}
