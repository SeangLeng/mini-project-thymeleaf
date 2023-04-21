package com.istad.thymeleafhomework.repository;

import com.istad.thymeleafhomework.Model.Articles;
import com.istad.thymeleafhomework.Model.Authors;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ArticleRepository {
    List<Articles> article = new ArrayList<>(){{
        add(new Articles(101, "is the best", "https://c4.wallpaperflare.com/wallpaper/14/548/927/the-avengers-avengers-endgame-avengers-endgame-infinity-gauntlet-iron-man-hd-wallpaper-preview.jpg", new AuthorRespository().getAllAuthor().get(0)));
        add(new Articles(102, "is not enough", "https://wallpapers.com/images/featured/axtz0jnhj20oq57g.jpg", new AuthorRespository().getAllAuthor().get(1)));
        add(new Articles(103, "Id is not better", "https://wallpapercg.com/download/monkey-d-luffy-6942x3905-7772.png", new AuthorRespository().getAllAuthor().get(2)));
        add(new Articles(104, "this is the most important", "https://avatars.githubusercontent.com/u/27896633?v=4", new AuthorRespository().getAllAuthor().get(2)));
    }};

    public List<Articles> getAllArticle(){
        return article;
    }
    public Articles getArticleByid(int id){
        return article.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }

    public List<Articles> getArticleByAuthorName(String name){
        return article.stream().filter(e-> Objects.equals(e.getAuthor().getName(), name)).toList();
    }
}
