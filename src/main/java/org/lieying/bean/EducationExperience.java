package org.lieying.bean;


import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="education_experience")
@Data
@Alias("EducationExperience")
public class EducationExperience implements Serializable {

	@Id
	@Column(name="education_experience_id")
	private Integer id;

	@Column(name="education_experience_school",length=50,nullable=false)
	private String school;

	@Column(name="education_experience_profession",length=20)
	private String profession;
	
	@Column(name="education_experience_time_quantum",length=9)
	private String timeQuantum;

	@Column(name="education_experience_school_experience",length=100)
	private String schoolExperience;
	
	@Column(name="education_experience_stage",length=10)
	private String stage;
	
	@ManyToOne(targetEntity=Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
}
