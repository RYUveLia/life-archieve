package life.lifearchieve.repository;

import life.lifearchieve.domain.Article;

import java.util.*;

public class MemoryArticleRepository implements ArticleRepository {
    private static Map<Long, Article> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Article save(Article article) {
        article.setId(++sequence);
        store.put(article.getId(), article);
        return article;
    }

    @Override
    public Optional<Article> lookup(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Article> findAllArticle() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
