package org.lieying.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

@Table(name="social_homepage")
@Data
@Alias("SocialHomepage")
public class SocialHomepage {
    @Id
    @Column(name="social_homepage_id")
    private int id;
    @Column(name="social_homepage_url")
    private String url;
    @Column(name="social_homepage_sign")
    private String sign;
    @Column(name="social_homepage_created_time")
    private java.util.Date createdTime;
    @Column(name="social_homepage_updated_time")
    private java.util.Date updatedTime;
    @ManyToOne(targetEntity=Resume.class)
    @JoinColumn(name="resume_id")
    private Resume resume;
}
