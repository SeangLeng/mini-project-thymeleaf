package com.istad.thymeleafhomework.repository;

import com.istad.thymeleafhomework.Model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    List<Category> categories = new ArrayList<>(){{
        add(new Category(1, "Sport"));
        add(new Category(2, "Programming"));
        add(new Category(3, "Education"));
        add(new Category(4, "Science"));
        add(new Category(5, "Biology"));
    }};

    public List<Category> getAllCategory(){
        return categories;
    }
}
