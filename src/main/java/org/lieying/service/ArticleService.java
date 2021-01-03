package org.lieying.service;

import com.github.pagehelper.PageInfo;
import org.lieying.bean.Article;

import java.util.List;

public interface ArticleService {
     List<Article> queryArticlesByJobHunterId(int jobHunterId);
     Article queryDetailArticleById(int articleId);
     PageInfo<Article> queryAllArticlesByPage(Integer page);
     Boolean addArticle(Article article);
}
