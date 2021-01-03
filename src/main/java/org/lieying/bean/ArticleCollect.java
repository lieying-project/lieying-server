package org.lieying.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = "handler")
@Data
@Alias("ArticleCollect")
@Table(name = "article_collect")
public class ArticleCollect implements Serializable {
	@Id
	@Column(name="article_collect_id")
	private Integer id;
	
	@ManyToOne(targetEntity=Article.class)
	@JoinColumn(name="article_id")
	private Article article;
	
	@ManyToOne(targetEntity=JobHunter.class)
	@JoinColumn(name="job_hunter_id")
	private JobHunter jobHunter;
	
	@Column(name="article_collect_created_time")
	private Date createdTime;
	
}
