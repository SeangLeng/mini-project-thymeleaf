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
    private String imgUrl = "https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png";
    private Authors author;
}
