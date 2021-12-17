package life.lifearchieve.controller;

import life.lifearchieve.domain.Article;
import life.lifearchieve.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("article/writeArticle")
    public String writeArticle() {
        return "article/writeArticle";
    }

    @PostMapping("article/writeArticle")
    public String create(ArticleForm form) {
        Article article = new Article();

        article.setTitle(form.getTitle());
        article.setContent(form.getContent());

        article.setAttach("");
        article.setTag("");

//        article.setAttach(form.getAttach());
//        article.setTag(form.getTag());

        articleService.write(article);

        return "redirect:/";
    }

    @GetMapping("article/list")
    public String list(Model model) {
        List<Article> articles = articleService.viewAllArticles();
        model.addAttribute("articles", articles);

        return "article/articleList";
    }

    @GetMapping("article/view/{no}")
    public String view(@PathVariable("no") Long no, Model model) {
        Article article = articleService.viewArticle(no).get();
        model.addAttribute("article", article);

        return "article/detail";
    }
}
