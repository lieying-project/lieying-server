package org.lieying.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
@JsonIgnoreProperties(value = "handler")
@Table(name="job_hunter")
@Data

public class JobHunter {

	@Id
	@Column(name="job_hunter_id")
	private Integer id;

	@Column(name="job_hunter_username",length=20,nullable=false,unique=true)
	private String username;

	@Column(name="job_hunter_password",length=18,nullable=false)
	private String password;

	@Column(name="job_hunter_email",length=320,unique=true)
	private String email;

	@Column(name="job_hunter_phone",length=11,nullable=false,unique=true)
	private String phone;

	@Column(name="job_hunter_name",length=15)
	private String name;

	@Column(name="job_hunter_sex",length=2)
	private String sex;

	@Column(name="job_hunter_birthday")
	private Date birthday;

	@Column(name="job_hunter_photo",length=1024)
	private String photo;

	@Column(name="job_hunter_education",length=6)
	private String education;

	@Column(name="job_hunter_interest",length=200)
	private String interest;

	@Column(name="job_hunter_address",length=40)
	private String address;

	@OneToMany(mappedBy = "jobHunter")
	private Set<Article> articles;

	@OneToMany(mappedBy="jobHunter")
	private Set<ArticleComment> articleComments;

	@OneToMany(mappedBy = "jobHunter")
	private Set<ArticleCommentRely> articleCommentRelies;

	@OneToMany(mappedBy="jobHunter")
	private Set<ArticleCollect> articleCollects;

	@OneToMany(mappedBy="jobHunter")
	private Set<ArticlePraise> articlePraises;

	@OneToMany(mappedBy="jobHunter")
	private Set<JobHunterOrder> jobHunterOrders;


	@OneToMany(mappedBy="jobHunter")
	private Set<Resume> resumes;


	@OneToMany(mappedBy = "jobHunter")
	private Set<PositionBrowse> positionBrowses;


	@OneToMany(mappedBy="jobHunter")
	private Set<Chat> chats;

	@OneToMany(mappedBy = "jobHunter")
	private Set<Interview> interviews;


	@OneToMany(mappedBy="jobHunter")
	private Set<JobHunterReport> jobHunterReports;

	@OneToMany(mappedBy="jobHunter")
	private Set<PositionCollect> positionCollects;

	@OneToMany(mappedBy = "jobHunter")
	private Set<JobHunterBrowse> jobHunterBrowses;


	transient private  String token;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JobHunter jobHunter = (JobHunter) o;
		return Objects.equals(id, jobHunter.id) &&
				Objects.equals(username, jobHunter.username) &&
				Objects.equals(password, jobHunter.password) &&
				Objects.equals(email, jobHunter.email) &&
				Objects.equals(phone, jobHunter.phone) &&
				Objects.equals(name, jobHunter.name) &&
				Objects.equals(sex, jobHunter.sex) &&
				Objects.equals(birthday, jobHunter.birthday) &&
				Objects.equals(photo, jobHunter.photo) &&
				Objects.equals(education, jobHunter.education) &&
				Objects.equals(interest, jobHunter.interest) &&
				Objects.equals(address, jobHunter.address) &&
				Objects.equals(articles, jobHunter.articles) &&
				Objects.equals(articleComments, jobHunter.articleComments) &&
				Objects.equals(articleCommentRelies, jobHunter.articleCommentRelies) &&
				Objects.equals(articleCollects, jobHunter.articleCollects) &&
				Objects.equals(articlePraises, jobHunter.articlePraises) &&
				Objects.equals(jobHunterOrders, jobHunter.jobHunterOrders) &&
				Objects.equals(resumes, jobHunter.resumes) &&
				Objects.equals(positionBrowses, jobHunter.positionBrowses) &&
				Objects.equals(chats, jobHunter.chats) &&
				Objects.equals(interviews, jobHunter.interviews) &&
				Objects.equals(jobHunterReports, jobHunter.jobHunterReports) &&
				Objects.equals(positionCollects, jobHunter.positionCollects) &&
				Objects.equals(jobHunterBrowses, jobHunter.jobHunterBrowses) &&
				Objects.equals(token, jobHunter.token);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password, email, phone, name, sex, birthday, photo, education, interest, address, articles, articleComments, articleCommentRelies, articleCollects, articlePraises, jobHunterOrders, resumes, positionBrowses, chats, interviews, jobHunterReports, positionCollects, jobHunterBrowses, token);
	}


}
