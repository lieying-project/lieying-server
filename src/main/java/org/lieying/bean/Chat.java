package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


import java.util.Date;

import javax.persistence.*;
@Table(name = "chat")
@JsonIgnoreProperties(value = "handler")
@Data

public class Chat  {

	@Id
	@Column(name="chat_id")
	private Integer id;

	@Column(name="chat_content",columnDefinition="text")
	private String content;
	
	@Column(name="chat_sent_date")
	private Date sentDate;

	@ManyToOne(targetEntity=JobHunter.class,fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="job_hunter_id")
	private JobHunter jobHunter;

	@ManyToOne(targetEntity=Recruiter.class,fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="recruiter_id")
	private Recruiter recruiter;


	@Column(name = "chat_sender_flag")
	private Boolean senderFlag;


	@Override
	public String toString() {
		return "Chat{" +
				"id=" + id +
				", content='" + content + '\'' +
				", sentDate=" + sentDate +
				", jobHunter=" + jobHunter +
				", recruiter=" + recruiter +
				", senderFlag=" + senderFlag +
				'}';
	}
}
