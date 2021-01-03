package org.lieying.service.impl;
import org.lieying.bean.Article;
import org.lieying.bean.ArticleCollect;
import org.lieying.bean.JobHunter;
import org.lieying.dao.ArticleCollectMapper;
import org.lieying.service.ArticleCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ArticleCollectServiceImpl implements ArticleCollectService {
    @Autowired
    private ArticleCollectMapper articleCollectMapper;

    @Override
    public Boolean addArticleCollect(ArticleCollect articleCollect) {
        Date createdTime=articleCollect.getCreatedTime();
        JobHunter jobHunter=articleCollect.getJobHunter();
        Article article=articleCollect.getArticle();
        if (jobHunter==null||article==null) {
            return null;
        }
        return articleCollectMapper.insertArticleCollect(createdTime,article.getId(),jobHunter.getId())==1;
    }

    @Override
    public Boolean removeArticleCollect(int id) {
        return articleCollectMapper.deleteArticleCollect(id)==1;
    }
}
