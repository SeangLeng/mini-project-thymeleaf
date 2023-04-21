package com.istad.thymeleafhomework.repository;

import com.istad.thymeleafhomework.Model.Authors;

import java.util.ArrayList;
import java.util.List;

public class AuthorRespository {
    List<Authors> authors = new ArrayList<>(){{
        add(new Authors(101, "IronMan", "https://playcontestofchampions.com/wp-content/uploads/2021/11/champion-iron-man-infinity-war.jpg",  "male", "James was born on October 6, 2004 to reigning NBA Rookie of the Year LeBron James, age 19, and his girlfriend Savannah Brinson", "IronMan.org@gmail.com", "phnomPenh"));
        add(new Authors(102, "SpiderMan", "https://i.pinimg.com/736x/42/d7/be/42d7beeaf3251080f7df2c6532ab3f57.jpg" ,"male", "A student of ISTAD", "SpiderMan.org@gmail.com", "UnitedState"));
        add(new Authors(103, "Lufy","https://yt3.googleusercontent.com/NG0QEKencmNbKKJpjANk9tqvtlHxvEpaFRu-50wkzti2TGXK9cPf5c7OCF2-LYsRquAALzjzRg=s900-c-k-c0x00ffffff-no-rj" ,  "female", "A student of American university of Phnom Penh", "vichara.org@gmail.com", "Phnom Penh"));


    }};
    public List<Authors> getAllAuthor(){
        return authors;
    }
}
