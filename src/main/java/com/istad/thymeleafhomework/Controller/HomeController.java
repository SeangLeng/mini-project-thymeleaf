package com.istad.thymeleafhomework.Controller;

import com.istad.thymeleafhomework.Model.Articles;
import com.istad.thymeleafhomework.Model.Authors;
import com.istad.thymeleafhomework.Model.Category;
import com.istad.thymeleafhomework.Model.request.RequestPost;
import com.istad.thymeleafhomework.repository.CategoryRepository;
import com.istad.thymeleafhomework.service.CategoryService;
import com.istad.thymeleafhomework.service.serviceIMP.ArticleIMP;
import com.istad.thymeleafhomework.service.serviceIMP.AuthorIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    CategoryService categoryService;
    ArticleIMP articleService;
    AuthorIMP authorSerive;
    @Autowired
    public HomeController(CategoryService categoryService, ArticleIMP articleService, AuthorIMP authorSerive) {
        this.categoryService = categoryService;
        this.articleService = articleService;
        this.authorSerive = authorSerive;
    }

    @GetMapping("/index")
    public String ReturnHomepage(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("allArticle", articleService.getAllArticle().stream().sorted(((o1, o2) -> o2.getId()-o1.getId())));
        return "index";
    }
    //author-profile/102
    @GetMapping("/author-profilev-view/{viewID}/{name}")
    public String viewArticleCardDetailByid(@PathVariable int viewID, @PathVariable String name,  Model model){
        model.addAttribute("UserPost", articleService.getArticleByAuthorName(name));
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("ViewAuthor", articleService.getViewDetailByID(viewID));
        return "author-profile";
    }

    @GetMapping("/AllUser")
    public String allUsersDisplay(Model model){
        model.addAttribute("Authors", authorSerive.getAllAuthor());
        model.addAttribute("allArticle", articleService.getAllArticle());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "AllUsers";
    }
    @GetMapping("new-article-form")
    public String getUserForm(Model model){
        model.addAttribute("article", new RequestPost());
        model.addAttribute("authors", authorSerive.getAllAuthor());
        model.addAttribute("categories",categoryService.getAllCategory());
        return "add-new-post";
    }

    @PostMapping("/handleAddArticle")
    public String handleArticle(@ModelAttribute RequestPost articles){
        System.out.println("Here is the value of article: " + articles);
        Articles newArticle = new Articles();
        newArticle.setDescription(articles.getDescription());
        newArticle.setCategory(newArticle.getCategory());
        Authors authors = authorSerive.getAllAuthor().stream().filter(e->e.getId() == articles.getAuthorID()).findFirst().orElse(null);
        newArticle.setAuthor(authors);
        newArticle.setId(articleService.getAllArticle().stream().max(Comparator.comparingInt(Articles::getId)).stream().toList().get(0).getId() + 1);
        List<Category> categories = new ArrayList<>();
        for (int cate : articles.getCategoryID()){
            categories.add(categoryService.getAllCategory().stream().filter(e->e.getId() == cate).findFirst().orElse(null));
        }
        Category[] categories1 = categories.toArray(new Category[0]);
        newArticle.setCategory(categories1);

        articleService.addNewArticle(newArticle);
        return "redirect:index";
    }
}
