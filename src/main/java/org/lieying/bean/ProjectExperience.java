package org.lieying.bean;


import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="project_experience")
@Data
@Alias("ProjectExperience")
public class ProjectExperience implements Serializable {

	@Id
	@Column(name="project_experience_id")
	private Integer id;

	@Column(name="project_experience_name",length=16,nullable=false)
	private String name;

	@Column(name="project_experience_role",length=16)
	private String role;
	
	@Column(name="project_experience_url")
	private String url;

	@Column(name="project_experience_start_time")
	private Date startTime;

	@Column(name="project_experience_end_time")
	private Date endTime;

	@Column(name="project_experience_description",length = 1600)
	private String description;

	@Column(name="project_experience_performance",length = 300)
	private String performance;
	
	@ManyToOne(targetEntity=Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
}
