package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@JsonIgnoreProperties(value = "handler")
@Data
@Table(name="resume")
@Alias("Resume")
public class Resume {

	@Id
	@Column(name="resume_id")
	private int id;

	@Column(name="resume_name",nullable=false,length=15)
	private String name;

	@Column(name="resume_education",length=6)
	private String education;

	@Column(name="resume_age",columnDefinition="int default 0")
	private int age;

	@Column(name="resume_advantage",length=200)
	private String advantage;

	@Column(name="resume_expected_city",length=10)
	private String expectedCity;

	@Column(name="resume_expected_position",length=20)
	private String expectedPosition;

	@Column(name="resume_expected_salary")
	private String expectedSalary;

	@Column(name="resume_work_address",length=40)
	private String workAddress;

	@Column(name="resume_work_experience",length=200)
	private String workExperience;

	@Column(name="resume_project_experience",length=200)
	private String projectExperience;

	@Column(name="resume_social_homepage",length=1024)
	private String socialHomepage;

	@Column(name="resume_volunteer_service_experience",length=200)
	private String volunteerServiceExperience;

	@Column(name="resume_enclosure",length=1024)
	private String enclosure;

	@Column(name="resume_reject_reason")
	private String rejectReason;

	@Column(name="resume_created_time")
	private Date createdTime;

	@Column(name="resume_updated_time")
	private Date updatedTime;

	@Column(name="resume_delivered_time")
	private Date deliveredTime;

	@Column(name="resume_state")
	private String state;

	@ManyToOne(targetEntity=JobHunter.class)
	@JoinColumn(name="job_hunter_id")
	private JobHunter jobHunter;

	@ManyToOne(targetEntity=Position.class)
	@JoinColumn(name="position_id")
	private Position position;

	@OneToMany(mappedBy="resume")
	private Set<EducationExperience> educationExperiences;

	@OneToMany(mappedBy="resume")
	private Set<Credential> credentials;

	@OneToMany(mappedBy="resume")
	private Set<ProjectExperience> projectExperiences;

	@OneToMany(mappedBy="resume")
	private Set<VolunteerExperience> volunteerExperiences;

	@OneToMany(mappedBy="resume")
	private Set<InternshipExperience> internshipExperiences;
}
