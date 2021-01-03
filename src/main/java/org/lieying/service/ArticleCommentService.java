package org.lieying.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.lieying.bean.ArticleComment;

import java.util.List;

public interface ArticleCommentService {
     ArticleComment queryArticleCommentById(int articleCommentId);
     List<ArticleComment> queryArticleCommentsByArticleId(int articleId);

     Boolean addArticleComment(ArticleComment articleComment);
}
