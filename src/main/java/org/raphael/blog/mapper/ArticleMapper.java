package org.raphael.blog.mapper;

import org.raphael.blog.dto.ArticleRequest;
import org.raphael.blog.dto.ArticleResponse;
import org.raphael.blog.model.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

        public Article toEntity(ArticleRequest request){
            Article newArticle = new Article();
            newArticle.setTitle(request.title());
            newArticle.setPublishTime(request.publishDateTime());
            newArticle.setContent(request.content());

            return newArticle;
        }

        public ArticleResponse toResponse(Article article){
          return new ArticleResponse(
                    article.getId(),
                    article.getTitle(),
                    article.getPublishDateTime(),
                    article.getContent());
        }
}
