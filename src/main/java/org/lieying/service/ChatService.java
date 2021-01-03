package org.lieying.service;


import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Chat;

import java.util.List;

public interface ChatService {


    boolean addChat(Chat chat);

    List<Chat> findChatsByJobHunterIdAndRecruiterId(
            int jobHunterId, int recruiterId);

    List<Chat> findChatsByJobHunterId(
            int jobHunterId);

    List<Chat> findChatsByRecruiterId(
            int recruiterId);
}
