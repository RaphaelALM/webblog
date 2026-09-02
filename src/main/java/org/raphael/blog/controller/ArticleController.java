package org.raphael.blog.controller;


import jakarta.validation.Valid;
import org.raphael.blog.dto.ArticleRequest;
import org.raphael.blog.dto.ArticleResponse;
import org.raphael.blog.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/new")
    public ResponseEntity<ArticleResponse> saveArticle(@Valid @RequestBody ArticleRequest articleRequest){

        ArticleResponse savedArticle = articleService.saveArticle(articleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> editArticle(@PathVariable Long id){
        ArticleResponse editedArticle = articleService.findById(id);

        return ResponseEntity.ok().body(editedArticle);
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articleResponseList = articleService.findAll();

        return ResponseEntity.ok().body(articleResponseList);
    }






}
