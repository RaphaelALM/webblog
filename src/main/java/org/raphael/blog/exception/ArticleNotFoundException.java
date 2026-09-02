package org.raphael.blog.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(Long id) {

        super("Article not found. ID = {" + id + "}");
    }
}
