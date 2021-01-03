package org.lieying.service;

import org.lieying.bean.ArticleCollect;

public interface ArticleCollectService {
    Boolean addArticleCollect(ArticleCollect articleCollect);
    Boolean removeArticleCollect(int id);
}
