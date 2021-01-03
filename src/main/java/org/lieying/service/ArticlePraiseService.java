package org.lieying.service;

import org.lieying.bean.ArticlePraise;

public interface ArticlePraiseService {
    Boolean addArticlePraise(ArticlePraise articlePraise);
    Boolean removeArticlePraise(int id);
}
