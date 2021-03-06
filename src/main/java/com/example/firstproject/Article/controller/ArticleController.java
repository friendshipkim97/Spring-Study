package com.example.firstproject.Article.controller;

import com.example.firstproject.Article.dto.ArticleForm;
import com.example.firstproject.Article.domain.Article;
import com.example.firstproject.Article.Repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Controller
public class ArticleController {

//    @Autowired // 스트링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
//    private ArticleRepository articleRepository;

    private final ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @Transactional
    @PostMapping("/articles/create") // 이 주소로 던져질때 이 메서드가 실행하는 것, 파라미터로 dto를 넣어줘야 한다.
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());

        // 1. Dto를 변환! Entity!
        Article article = form.toEntity();
        System.out.println(article.toString());

        // 2. Repository에게 Entity를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);
        saved.setTitle("abc");
        System.out.println(saved.toString());

        return "";
    }

}
