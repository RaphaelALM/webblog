package org.raphael.blog.service;

import org.raphael.blog.dto.ArticleRequest;
import org.raphael.blog.dto.ArticleResponse;
import org.raphael.blog.mapper.ArticleMapper;
import org.raphael.blog.model.Article;
import org.raphael.blog.repository.ArticleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper mapper;

    public ArticleService(ArticleRepository articleRepository, ArticleMapper mapper) {
        this.articleRepository = articleRepository;
        this.mapper = mapper;
    }


    public ArticleResponse saveArticle(ArticleRequest request){

        Article savedArticle = mapper.toEntity(request);
        try {
             articleRepository.save(savedArticle);

        } catch (Exception e){
            System.out.println("DEU RUIM");
        }
        return mapper.toResponse(savedArticle);
    }



}
