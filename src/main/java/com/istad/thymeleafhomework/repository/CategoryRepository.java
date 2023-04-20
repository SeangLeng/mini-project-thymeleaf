package com.istad.thymeleafhomework.repository;

import com.istad.thymeleafhomework.Model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    List<Category> categories = new ArrayList<>(){{
        add(new Category("Programming"));
        add(new Category("Sport"));
        add(new Category("Education"));
        add(new Category("Science"));
        add(new Category("Biology"));
    }};

    public List<Category> getAllCategory(){
        return categories;
    }
}
