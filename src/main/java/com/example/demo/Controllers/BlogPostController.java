package com.example.demo.Controllers;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Entities._Category_;
import com.example.demo.Services.BlogPostService;
import com.example.demo.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class BlogPostController {
    @Autowired
    BlogPostService blogPostService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/CreatePost")
    public String CreateCategory(ModelMap modelMap){
        List<_Category_> cats_list=categoryService.getAllCategories();
        modelMap.addAttribute("catsView",cats_list);
        return "CreateBlogPost";
    }

    @RequestMapping("SaveBlogPost")
    public String SaveBlogPost(@ModelAttribute("post")_BlogPost_ blogPost)throws ParseException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        blogPost.setCreated_At(formattedDateTime);
        blogPost.setUpdated_At(formattedDateTime);
        blogPostService.SaveBlogPost(blogPost);
        return "CreateBlogPost";
    }

    @RequestMapping("/AllPosts")
    public String AllPosts(ModelMap modelMap,
                           @RequestParam(name="page",defaultValue = "0")int page,
                           @RequestParam(name="size",defaultValue = "2")int size
                           ){
        Page<_BlogPost_> blogs_list=blogPostService.GetAllBlogsByPage(page,size);
        modelMap.addAttribute("blogs_list",blogs_list);
        modelMap.addAttribute("pages",new int[blogs_list.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "ArticlesPanel";
    }

    @RequestMapping("/ShowPost")
    public String ShowPost(@RequestParam("id") Long id, ModelMap modelMap){
        _BlogPost_ blogPost=blogPostService.GetBlogPostById(id);
        modelMap.addAttribute("blog",blogPost);
        return "EditBlogPost";
    }

    @RequestMapping("/UpdateBlogPost")
    public String updateCategory(@ModelAttribute ("blog") _BlogPost_ blog,ModelMap modelMap,
                                 @RequestParam(name="page",defaultValue = "0")int page,
                                 @RequestParam(name="size",defaultValue = "2")int size){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        blog.setUpdated_At(formattedDateTime);
        blogPostService.updateBlogPost(blog);

        Page<_BlogPost_> blogs_list=blogPostService.GetAllBlogsByPage(page,size);
        modelMap.addAttribute("blogs_list",blogs_list);
        modelMap.addAttribute("pages",new int[blogs_list.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "ArticlesPanel";

    }


    @RequestMapping("/ThatPost")
    public String ThatPost(@RequestParam("id") Long id, ModelMap modelMap){
        _BlogPost_ blog=blogPostService.GetBlogPostById(id);
        modelMap.addAttribute("blogView",blog);
        return "post";
    }


    @RequestMapping("/DeletePost")
    public String DeletePost(@RequestParam("id") Long id,ModelMap modelMap, @RequestParam(name="page",defaultValue = "0")int page,
                             @RequestParam(name="size",defaultValue = "2")int size){
        blogPostService.deleteBlogPostById(id);

        Page<_BlogPost_> blogs_list=blogPostService.GetAllBlogsByPage(page,size);
        modelMap.addAttribute("blogs_list",blogs_list);
        modelMap.addAttribute("pages",new int[blogs_list.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "ArticlesPanel";
    }

    @RequestMapping(value = {"/Index", "/"})
    public String index(ModelMap modelMap){
        List<_BlogPost_> blogs_list=blogPostService.getRecentBlogPosts(3);
       modelMap.addAttribute("post_list",blogs_list);
        return "index";
    }
}
