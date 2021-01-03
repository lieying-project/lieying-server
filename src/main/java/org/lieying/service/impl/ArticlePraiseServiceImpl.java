package org.lieying.service.impl;

import org.lieying.bean.Article;
import org.lieying.bean.ArticlePraise;
import org.lieying.bean.JobHunter;
import org.lieying.dao.ArticlePraiseMapper;
import org.lieying.service.ArticlePraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticlePraiseServiceImpl implements ArticlePraiseService {
    @Autowired
    private ArticlePraiseMapper articlePraiseMapper;
    @Override
    public Boolean addArticlePraise(ArticlePraise articlePraise) {
        Date createdTime=articlePraise.getCreatedTime();
        JobHunter jobHunter=articlePraise.getJobHunter();
        Article article=articlePraise.getArticle();
        if (jobHunter==null||article==null) {
            return null;
        }
        return articlePraiseMapper.insertArticlePraise(createdTime,article.getId(),
                jobHunter.getId())==1;
    }

    @Override
    public Boolean removeArticlePraise(int id) {
        return articlePraiseMapper.deleteArticlePraise(id)==1;
    }
}
