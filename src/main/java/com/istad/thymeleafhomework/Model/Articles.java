package com.istad.thymeleafhomework.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articles {
    private int id;
    private String description;
    private Authors author;
    private Category[] category;
    private String post_img;
}
