package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties(value = "handler")
@Table(name = "article_comment")
@Data
@Alias("ArticleComment")
public class ArticleComment implements Serializable {
	
	@Id
	@Column(name="article_comment_id")
	private Integer id;
	
	@ManyToOne(targetEntity=Article.class)
	@JoinColumn(name="article_id")
	private Article article;
	
	@ManyToOne(targetEntity=JobHunter.class)
	@JoinColumn(name="job_hunter_id")
	private JobHunter jobHunter;

	@Column(name="article_comment_content")
	private String content;

	@Column(name="article_comment_created_time")
	private Date createdTime;


	@OneToMany(mappedBy = "articleComment")
	private Set<ArticleCommentRely> articleCommentRelies;


}
