package org.raphael.blog.controller;


import jakarta.validation.Valid;
import org.raphael.blog.dto.ArticleRequest;
import org.raphael.blog.dto.ArticleResponse;
import org.raphael.blog.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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




}
