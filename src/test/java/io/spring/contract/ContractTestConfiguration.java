package io.spring.contract;

import io.spring.application.ArticleQueryService;
import io.spring.application.Page;
import io.spring.application.data.ArticleData;
import io.spring.application.data.ArticleDataList;
import io.spring.application.data.ProfileData;
import io.spring.application.data.UserData;
import io.spring.core.service.JwtService;
import io.spring.core.user.FollowRelation;
import io.spring.core.user.User;
import io.spring.core.user.UserRepository;
import io.spring.infrastructure.mybatis.readservice.ArticleFavoritesReadService;
import io.spring.infrastructure.mybatis.readservice.ArticleReadService;
import io.spring.infrastructure.mybatis.readservice.UserReadService;
import io.spring.infrastructure.mybatis.readservice.UserRelationshipQueryService;
import org.joda.time.DateTime;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestConfiguration
@Profile("contract-test")
public class ContractTestConfiguration {

    @Bean
    @Primary
    public ArticleReadService articleReadService() {
        return new ArticleReadService() {
            @Override
            public ArticleData findBySlug(String slug) {
                System.out.println("ArticleReadService.findBySlug called with slug: " + slug);
            if ("sample-article".equals(slug)) {
                    DateTime now = new DateTime();
                    return new ArticleData(
                        "sample-article-id",
                        "sample-article",
                        "Sample Article",
                        "This is a sample article",
                        "Article body content",
                        false,
                        0,
                        now,
                        now,
                        Arrays.asList("java", "spring"),
                        new ProfileData("testuser-id", "testuser", "Test Bio", "https://example.com/avatar.jpg", false)
                    );
                }
                return null;
            }

            @Override
            public ArticleData findById(String id) {
                if ("sample-article-id".equals(id)) {
                    DateTime now = new DateTime();
                    return new ArticleData(
                        "sample-article-id",
                        "sample-article",
                        "Sample Article",
                        "This is a sample article",
                        "Article body content",
                        false,
                        0,
                        now,
                        now,
                        Arrays.asList("java", "spring"),
                        new ProfileData("testuser-id", "testuser", "Test Bio", "https://example.com/avatar.jpg", false)
                    );
                }
                return null;
            }

            @Override
            public List<String> queryArticles(String tag, String author, String favoritedBy, Page page) {
                return Arrays.asList("sample-article-id");
            }

            @Override
            public List<ArticleData> findArticles(List<String> articleIds) {
                DateTime now = new DateTime();
                return Arrays.asList(new ArticleData(
                    "sample-article-id",
                    "sample-article",
                    "Sample Article",
                    "This is a sample article",
                    "Article body content",
                    false,
                    0,
                    now,
                    now,
                    Arrays.asList("java", "spring"),
                    new ProfileData("testuser-id", "testuser", "Test Bio", "https://example.com/avatar.jpg", false)
                ));
            }

            @Override
            public int countArticle(String tag, String author, String favoritedBy) {
                return 1;
            }

            @Override
            public List<ArticleData> findArticlesOfAuthors(List<String> authors, io.spring.application.Page page) {
                DateTime now = new DateTime();
                return Arrays.asList(new ArticleData(
                    "sample-article-id",
                    "sample-article",
                    "Sample Article",
                    "This is a sample article",
                    "Article body content",
                    false,
                    0,
                    now,
                    now,
                    Arrays.asList("java", "spring"),
                    new ProfileData("testuser-id", "testuser", "Test Bio", "https://example.com/avatar.jpg", false)
                ));
            }

            @Override
            public List<ArticleData> findArticlesOfAuthorsWithCursor(List<String> authors, io.spring.application.CursorPageParameter page) {
                DateTime now = new DateTime();
                return Arrays.asList(new ArticleData(
                    "sample-article-id",
                    "sample-article",
                    "Sample Article",
                    "This is a sample article",
                    "Article body content",
                    false,
                    0,
                    now,
                    now,
                    Arrays.asList("java", "spring"),
                    new ProfileData("testuser-id", "testuser", "Test Bio", "https://example.com/avatar.jpg", false)
                ));
            }

            @Override
            public int countFeedSize(List<String> authors) {
                return 1;
            }

            @Override
            public List<String> findArticlesWithCursor(String tag, String author, String favoritedBy, io.spring.application.CursorPageParameter page) {
                return Arrays.asList("sample-article-id");
            }
        };
    }

    @Bean
    @Primary
    public UserRelationshipQueryService userRelationshipQueryService() {
        return new UserRelationshipQueryService() {
            @Override
            public List<String> followedUsers(String userId) {
                return Arrays.asList("testuser-id");
            }

            @Override
            public boolean isUserFollowing(String userId, String targetId) {
                return false;
            }

            @Override
            public java.util.Set<String> followingAuthors(String userId, List<String> ids) {
                return java.util.Collections.emptySet();
            }
        };
    }

    @Bean
    @Primary
    public ArticleFavoritesReadService articleFavoritesReadService() {
        return new ArticleFavoritesReadService() {
            @Override
            public boolean isUserFavorite(String userId, String articleId) {
                return false;
            }

            @Override
            public int articleFavoriteCount(String articleId) {
                return 0;
            }

            @Override
            public List<io.spring.application.data.ArticleFavoriteCount> articlesFavoriteCount(List<String> ids) {
                return java.util.Collections.emptyList();
            }

            @Override
            public java.util.Set<String> userFavorites(List<String> ids, User currentUser) {
                return java.util.Collections.emptySet();
            }
        };
    }

    @Bean
    @Primary
    public UserRepository userRepository() {
        return new UserRepository() {
            @Override
            public Optional<User> findByUsername(String username) {
                if ("testuser".equals(username)) {
                    return Optional.of(new User("test@example.com", "testuser", "password", "Test Bio", "https://example.com/avatar.jpg"));
                }
                return Optional.empty();
            }

            @Override
            public Optional<User> findById(String id) {
                if ("testuser-id".equals(id)) {
                    return Optional.of(new User("test@example.com", "testuser", "password", "Test Bio", "https://example.com/avatar.jpg"));
                }
                return Optional.empty();
            }

            @Override
            public Optional<User> findByEmail(String email) {
                if ("test@example.com".equals(email)) {
                    return Optional.of(new User("test@example.com", "testuser", "password", "Test Bio", "https://example.com/avatar.jpg"));
                }
                return Optional.empty();
            }

            @Override
            public void save(User user) {}

            @Override
            public void saveRelation(FollowRelation followRelation) {}

            @Override
            public Optional<FollowRelation> findRelation(String userId, String targetId) {
                return Optional.empty();
            }

            @Override
            public void removeRelation(FollowRelation followRelation) {}
        };
    }

    @Bean
    @Primary
    public UserReadService userReadService() {
        return new UserReadService() {
            @Override
            public UserData findById(String id) {
                if ("testuser-id".equals(id)) {
                    return new UserData("testuser-id", "test@example.com", "testuser", "Test Bio", "https://example.com/avatar.jpg");
                }
                return null;
            }

            @Override
            public UserData findByUsername(String username) {
                if ("testuser".equals(username)) {
                    return new UserData("testuser-id", "test@example.com", "testuser", "Test Bio", "https://example.com/avatar.jpg");
                }
                return null;
            }
        };
    }

    @Bean
    @Primary
    public JwtService jwtService() {
        return new JwtService() {
            @Override
            public Optional<String> getSubFromToken(String token) {
                return Optional.of("testuser-id");
            }

            @Override
            public String toToken(User user) {
                return "test-token";
            }
        };
    }

    @Bean
    @Primary
    public ArticleQueryService articleQueryService() {
        System.out.println("DEBUG: Creating ArticleQueryService mock bean");
        return new ArticleQueryService(null, null, null) {
            @Override
            public Optional<ArticleData> findBySlug(String slug, User user) {
                System.out.println("DEBUG: ArticleQueryService.findBySlug called with slug: " + slug + ", user: " + (user != null ? user.getUsername() : "null"));
                if ("sample-article".equals(slug)) {
                    DateTime now = new DateTime();
                    ProfileData profileData = new ProfileData("testuser-id", "testuser", "Test Bio", "https://example.com/avatar.jpg", false);
                    return Optional.of(new ArticleData(
                        "sample-article-id",
                        "sample-article",
                        "Sample Article",
                        "This is a sample article",
                        "Article body content",
                        false,
                        0,
                        now,
                        now,
                        Arrays.asList("java", "spring"),
                        profileData
                    ));
                }
                return Optional.empty();
            }
        };
    }
}
