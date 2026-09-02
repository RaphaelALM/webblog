package org.raphael.blog.service;

import org.raphael.blog.dto.ArticleRequest;
import org.raphael.blog.dto.ArticleResponse;
import org.raphael.blog.exception.ArticleNotFoundException;
import org.raphael.blog.mapper.ArticleMapper;
import org.raphael.blog.model.Article;
import org.raphael.blog.repository.ArticleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper mapper;

    public ArticleService(ArticleRepository articleRepository, ArticleMapper mapper) {
        this.articleRepository = articleRepository;
        this.mapper = mapper;
    }


    // Save new article
    public ArticleResponse saveArticle(ArticleRequest request){

        Article savedArticle = mapper.toEntity(request);
        try {
             articleRepository.save(savedArticle);

        } catch (Exception e){
            System.out.println("DEU RUIM");
        }
        return mapper.toResponse(savedArticle);
    }


    // find ONE article
    public ArticleResponse findById(Long id){

        Article foundArticle = articleRepository
                .findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));

        return mapper.toResponse(foundArticle);
    }

    // find ALL articles
    public List<ArticleResponse> findAll(){

        List<Article> articleList = articleRepository.findAll();

        return articleList.stream()
                .map(mapper::toResponse)
                .toList();
    }



    // edit article
//    public ArticleResponse editArticle(Long id, ArticleRequest request){
//           return
//    }

    //

}
