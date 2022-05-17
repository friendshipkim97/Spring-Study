package com.example.firstproject.Article.Repository;

import com.example.firstproject.Article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> { // Crud란 Create, read, update, delete이다.
}
