package com.istad.thymeleafhomework.Controller;

import com.istad.thymeleafhomework.repository.CategoryRepository;
import com.istad.thymeleafhomework.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    CategoryRepository categoryRepository;

    @Autowired
    HomeController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/index")
    public String ReturnHomepage(Model model){
        model.addAttribute("categories", categoryRepository.getAllCategory());
        return "index";
    }
}
