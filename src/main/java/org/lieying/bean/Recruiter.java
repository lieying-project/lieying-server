package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@JsonIgnoreProperties(value = "handler")
@Table(name = "recruiter")
@Data

public class Recruiter implements Serializable {

	@Id
	@Column(name = "recruiter_id")
	private Integer id;

	@Column(name="recruiter_username",length=20,nullable=false)
	private String username;

	@Column(name="recruiter_name",length=20,nullable=false)
	private String name;

	@Column(name="recruiter_intro",nullable=false)
	private String intro;

	@Column(name="recruiter_password",length=18,nullable=false)
	private String password;

	@Column(name="recruiter_position",length=20,nullable=false)
	private String position;

	@Column(name="recruiter_phone",length=11,nullable=false,unique=true)
	private String phone;

	@Column(name="recruiter_photo",length=1024)
	private String photo;

	@ManyToOne(targetEntity=Company.class)
	@JoinColumn(name="company_id")
	private Company company;

	@OneToMany(mappedBy="recruiter")
	private Set<Position> positions;

	@OneToMany(mappedBy="recruiter")
	private Set<Chat> chats;

	@OneToMany(mappedBy = "recruiter")
	private Set<JobHunterBrowse> jobHunterBrowses;

	@OneToMany(mappedBy = "recruiter")
	private Set<Interview> interviews;


}
