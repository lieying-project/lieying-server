package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@JsonIgnoreProperties(value = "handler")
@Data

@Table(name = "article")
public class Article implements Serializable {
    @Id
    @Column(name = "article_id")
    private Integer id;

    @Column(name = "article_title", length = 40)
    private String title;

    @Column(name = "article_content", columnDefinition = "text")
    private String content;

    @Column(name = "article_created_time")
    private Date createdTime;

    @Column(name = "article_updated_time")
    private Date updatedTime;

    @Column(name = "article_state")
    private String state;

    @ManyToOne(targetEntity = JobHunter.class)
    @JoinColumn(name = "job_hunter_id")
    private JobHunter jobHunter;

    @OneToMany(mappedBy = "article")
    private Set<ArticleComment> articleComments;

    @OneToMany(mappedBy = "article")
    private Set<ArticleCollect> articleCollects;

    @OneToMany(mappedBy = "article")
    private Set<ArticlePraise> articlePraises;

}
