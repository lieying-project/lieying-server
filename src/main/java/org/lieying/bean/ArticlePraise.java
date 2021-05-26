package org.lieying.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties(value = "handler")
@Table(name = "article_praise")
@Data

public class ArticlePraise implements Serializable {
	@Id
	@Column(name="article_praise_id")
	private Integer id;

	@Column(name="article_praise_created_time")
	private Date createdTime;

	@ManyToOne(targetEntity=Article.class)
	@JoinColumn(name="article_id")
	private Article article;

	@ManyToOne(targetEntity=JobHunter.class)
	@JoinColumn(name="job_hunter_id")
	private JobHunter jobHunter;
}
