package org.raphael.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "article_tb")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime publishDateTime;
    private String content;

    public Article(){

    }

    public Article(Long id, String title, LocalDateTime publishDateTime, String content) {
        this.id = id;
        this.title = title;
        this.publishDateTime = publishDateTime;
        this.content = content;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
         this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishTime(LocalDateTime publishDateTime) {
        this.publishDateTime = publishDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Article article = (Article) object;
        return Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishTime=" + publishDateTime +
                ", content='" + content + '\'' +
                '}';
    }
}
