package com.istad.thymeleafhomework.Controller;

import com.istad.thymeleafhomework.repository.CategoryRepository;
import com.istad.thymeleafhomework.service.serviceIMP.ArticleIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    CategoryRepository categoryRepository;
    ArticleIMP articleService;
    @Autowired
    public HomeController(CategoryRepository categoryRepository, ArticleIMP articleService) {
        this.categoryRepository = categoryRepository;
        this.articleService = articleService;
    }
    @GetMapping("/index")
    public String ReturnHomepage(Model model){
        model.addAttribute("categories", categoryRepository.getAllCategory());
        model.addAttribute("allArticle", articleService.getAllArticle());
        return "index";
    }
    //author-profile/102
    @GetMapping("/author-profilev-view/{viewID}/{name}")
    public String viewArticleCardDetailByid(@PathVariable int viewID, @PathVariable String name,  Model model){
        model.addAttribute("UserPost", articleService.getArticleByAuthorName(name));
        model.addAttribute("ViewAuthor", articleService.getViewDetailByID(viewID));
        return "author-profile";
    }
}
