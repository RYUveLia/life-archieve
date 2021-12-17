package life.lifearchieve.service;

import life.lifearchieve.domain.Article;
import life.lifearchieve.repository.ArticleRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class ArticleService {
    public final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // 글쓰기
    public long write(Article article) {
        articleRepository.save(article);
        return article.getId();
    }

    // 글 하나 조회
    public Optional<Article> viewArticle(Long no) {
        return articleRepository.lookup(no);
    }

    // 글 목록 불러오기
    public List<Article> viewAllArticles() {
        return articleRepository.findAllArticle();
    }
}
