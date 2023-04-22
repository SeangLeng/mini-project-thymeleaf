package com.istad.thymeleafhomework.Model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.awt.font.MultipleMaster;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPost {
    private int id;
    private String name;
    private String description;
    private int authorID;
    private int[] categoryID;
    private MultipartFile file;
}
