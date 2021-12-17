package life.lifearchieve.repository;

import life.lifearchieve.domain.Article;

import java.util.List;
import java.util.Optional;


public interface ArticleRepository {
    //구현해야 하는 기능들

    //게시글 저장
    Article save(Article article);

    //게시글 하나 조회
    Optional<Article> lookup(Long id);

    //게시글 전체보기
    List<Article> findAllArticle();
}
