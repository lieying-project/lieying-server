package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@JsonIgnoreProperties(value="handler")
@Alias("ArticleCommentRely")
@Data
public class ArticleCommentRely {

    @Id
    @Column(name="article_comment_rely_id")
    private int id;

    @Column(name="article_comment_rely_content")
    private String content;

    @Column(name="article_comment_rely_created_time")
    private Date createdTime;

    @Column(name="article_comment_rely_updated_time")
    private Date updatedTime;

    @ManyToOne(targetEntity = JobHunter.class)
    @JoinColumn(name = "job_hunter_id")
    private JobHunter jobHunter;

    @ManyToOne(targetEntity = ArticleComment.class)
    @JoinColumn(name="article_comment_id")
    private ArticleComment articleComment;

    @ManyToOne(targetEntity = ArticleCommentRely.class)
    @JoinColumn(name = "parent_article_comment_rely_id")
    private ArticleCommentRely parentArticleCommentRely;

    @OneToMany(mappedBy = "parentArticleCommentRely")
    private Set<ArticleCommentRely> sonArticleCommentRelies;

}


