package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.blog.IBlogService;
import com.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @RequestMapping("/")
    public String home(){
        return "redirect:usercategory";
    }

    @GetMapping("/usercategory")
    public ModelAndView listCategory(){
        Iterable<Category> categories = categoryService.findAll();

        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }

    @GetMapping("/admincreate-category")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category",new Category());

        return modelAndView;
    }

    @PostMapping("/adminsave-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category",new Category());
        modelAndView.addObject("message","Created category successful");

        return modelAndView;
    }

    @GetMapping("/adminedit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Category category = categoryService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category",category);

        return modelAndView;
    }

    @PostMapping("/adminupdate-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category",category);
        modelAndView.addObject("message","Updated category successful");

        return modelAndView;
    }

    @GetMapping("/adminremove-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Category category = categoryService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/category/remove");
        modelAndView.addObject("category",category);

        return modelAndView;
    }

    @PostMapping("/admindelete-category")
    public ModelAndView removeCategory(@ModelAttribute("category") Category category){
        categoryService.remove(category.getId());

        return listCategory();
    }

    @GetMapping("/userview-category/{id}")
    public ModelAndView viewMore(@PathVariable ("id") Long id){
        Category category = categoryService.findById(id);

        Iterable<Blog> blogs = blogService.findAllByCategory(category);

        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category",category);
        modelAndView.addObject("blogs",blogs);

        return modelAndView;
    }
}