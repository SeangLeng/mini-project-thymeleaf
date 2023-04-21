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
        add(new Articles(101, "Tony Stark is the wealthy son of industrialist and weapons manufacturer Howard Stark and his wife, Maria.", new AuthorRespository().getAllAuthor().get(0)));
        add(new Articles(102, "Bitten by a radioactive spider, Peter Parker's arachnid abilities give him amazing powers he uses to help others, while his personal life continues to offer plenty of obstacles", new AuthorRespository().getAllAuthor().get(1)));
        add(new Articles(103, "Monkey D. Luffy (/ˈluːfi/ LOO-fee) (Japanese: モンキー・D・ルフィ, Hepburn: Monkī Dī Rufi, [ɾɯɸiː]), also known as \"Straw Hat\" Luffy, is a fictional character and the protagonist of the One Piece manga series, created by Eiichiro Oda.\n", new AuthorRespository().getAllAuthor().get(2)));
        add(new Articles(104, "Monkey D. Luffy, also known as \"Straw Hat Luffy\" and commonly as \"Straw Hat\", is the founder and captain of the increasingly infamous and powerful Straw Hat Pirates, as well as the most powerful of its top fighters.",  new AuthorRespository().getAllAuthor().get(2)));
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
