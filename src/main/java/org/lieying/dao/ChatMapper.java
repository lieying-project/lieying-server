package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.Chat;

import java.awt.*;
import java.util.List;

public interface ChatMapper {


    int insertChat(@Param("job_hunter_id") int jobHunterId,
                   @Param("recruiter_id") int recruiterId,
                   @Param("chat_content") String chatContent,
                   @Param("chat_sent_date") java.util.Date sendDate,
                   @Param("chat_sender_flag") boolean chat_sender_flag);

    List<Chat> selectChatsByJobHunterIdAndRecruiterId(
            @Param("job_hunter_id") int jobHunterId, @Param("recruiter_id") int recruiterId);

    List<Chat> selectDetailChatsByJobHunterId(
            @Param("job_hunter_id") int jobHunterId);

    List<Chat> selectDetailChatsByRecruiterId(
            @Param("recruiter_id") int recruiterId);

}
