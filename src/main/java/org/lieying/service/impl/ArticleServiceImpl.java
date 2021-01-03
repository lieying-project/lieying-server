package org.lieying.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.lieying.bean.Article;
import org.lieying.bean.JobHunter;
import org.lieying.dao.ArticleMapper;
import org.lieying.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.rmi.CORBA.Tie;
import java.util.Date;
import java.util.List;

@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

//    @Cacheable(value = "cache1")
    @Transactional(readOnly = true)
    @Override
    public List<Article> queryArticlesByJobHunterId(int jobHunterId) {
        return articleMapper.selectArticlesByJobHunterId(jobHunterId);
    }
//    @Cacheable(value = "cache1")
    @Transactional(readOnly = true)
    @Override
    public Article queryDetailArticleById(int articleId) {
        return articleMapper.selectDetailArticleById(articleId);
    }

    @Override
    public PageInfo<Article> queryAllArticlesByPage(Integer page) {
        int pageSize = 2;
        System.out.println("page:" + page + " pageSize:" + pageSize);
        if (page == null) {
            page = 1;
        }
        PageHelper.startPage(page, pageSize);
        List<Article> articles=articleMapper.selectAllArticles();
        PageInfo<Article> pageInfo=new PageInfo<>(articles);

        return pageInfo;
    }

    @Override
    public Boolean addArticle(Article article) {
        String title=article.getTitle();
        String content=article.getContent();
        Date createdTime=article.getCreatedTime();
        Date updatedTime=article.getUpdatedTime();
        JobHunter jobHunter=article.getJobHunter();
        if (jobHunter==null){
            return null;
        }
        int row=articleMapper.insertArticle(title,content,createdTime,updatedTime,jobHunter.getId());

        System.out.println(article.getId());
        return row==1;
    }
}
