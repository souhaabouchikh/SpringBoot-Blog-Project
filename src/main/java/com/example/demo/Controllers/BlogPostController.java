package com.example.demo.Controllers;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Entities._Category_;
import com.example.demo.Entities._Comment_;
import com.example.demo.Services.BlogPostService;
import com.example.demo.Services.CategoryService;
import com.example.demo.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @Autowired
    CommentService commentService;

    @RequestMapping("/CreatePost")
    public String CreateCategory(ModelMap modelMap){
        List<_Category_> cats_list=categoryService.getAllCategories();
        modelMap.addAttribute("catsView",cats_list);
        List<_Category_> categories = categoryService.getAllCategories();
        modelMap.addAttribute("dropdown", categories);
        return "CreateBlogPost";
    }

    @RequestMapping("SaveBlogPost")
    public String SaveBlogPost(@ModelAttribute("post")_BlogPost_ blogPost, MultipartFile file)throws ParseException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        // Image Upload Logic
        if (file.isEmpty()) {
            System.out.println("Please select a file");
        } else {
            try {
                // Get the filename and build the local file path
                String fileName = file.getOriginalFilename();
                String directoryPath = System.getProperty("user.dir")+"/src/main/resources/static/images/BlogsImages/"; // Change the directory as per your requirement
                System.out.println("in try");
                System.out.println(System.getProperty("user.dir"));
                // Create the directory if it does not exist
                File directory = new File(directoryPath);
                if (!directory.exists()) {
                    System.out.println("directory created");
                    directory.mkdirs(); // Create directories including any necessary but nonexistent parent directories
                }

                String filePath = directoryPath + fileName;
                System.out.println(filePath.toString());
                // Save the file to the local file system
                File dest = new File(filePath);
                file.transferTo(dest);
                blogPost.setImage("images/BlogsImages/"+fileName);
                blogPost.setCreated_At(formattedDateTime);
                blogPost.setUpdated_At(formattedDateTime);
                blogPostService.SaveBlogPost(blogPost);
            } catch (IOException e) {
                System.out.println("Failed to upload file Exception " + e.getMessage());

            }
        }
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
        List<_Category_> categories = categoryService.getAllCategories();
        modelMap.addAttribute("dropdown", categories);
        return "EditBlogPost";
    }

    @RequestMapping("/BlogPostByCategory")
    public String BlogPostByCategory(){
        return "BlogPostByCategory";
    }

    @RequestMapping("/UpdateBlogPost")
    public String updateCategory(@ModelAttribute ("blog") _BlogPost_ blog,ModelMap modelMap,
                                 @RequestParam(name="page",defaultValue = "0")int page,
                                 @RequestParam(name="size",defaultValue = "2")int size,
                                 MultipartFile file){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);


        // Image Upload Logic (Optional)
        if (file != null && !file.isEmpty()) {
            System.out.println("im in the image being uploaded");
            try {
                // Get the filename and build the local file path
                String fileName = file.getOriginalFilename();
                String directoryPath = System.getProperty("user.dir")+"/src/main/resources/static/images/BlogsImages/"; // Change the directory as per your requirement

                System.out.println("in try of the uploaded file"+ directoryPath);
                // Create the directory if it does not exist

                File directory = new File(directoryPath);
                if (!directory.exists()) {
                    System.out.println("directory created");
                    directory.mkdirs(); // Create directories including any necessary but nonexistent parent directories
                }

                String filePath = directoryPath + fileName;
                System.out.println(filePath.toString());
                // Save the file to the local file system
                File dest = new File(filePath);
                file.transferTo(dest);

                blog.setImage("images/BlogsImages/"+fileName);
                blog.setUpdated_At(formattedDateTime);
                System.out.println("the image is set to: "+blog.getImage());

                blogPostService.updateBlogPost(blog);

                Page<_BlogPost_> blogs_list=blogPostService.GetAllBlogsByPage(page,size);
                modelMap.addAttribute("blogs_list",blogs_list);
                modelMap.addAttribute("pages",new int[blogs_list.getTotalPages()]);
                modelMap.addAttribute("currentPage",page);
                return "ArticlesPanel";
            } catch (IOException e) {
                System.out.println("Failed to upload file Exception " + e.getMessage());

            }
        } else {
            // Handle the case where no file was uploaded (optional)
            System.out.println("im in the else of not having the file uploaded");
            blog.setUpdated_At(formattedDateTime);

            blogPostService.updateBlogPostSelective(blog.getId(), blog.getTitle(), blog.getContent(), formattedDateTime);

            Page<_BlogPost_> blogs_list=blogPostService.GetAllBlogsByPage(page,size);
            modelMap.addAttribute("blogs_list",blogs_list);
            modelMap.addAttribute("pages",new int[blogs_list.getTotalPages()]);
            modelMap.addAttribute("currentPage",page);
            return "ArticlesPanel";
        }

        Page<_BlogPost_> blogs_list=blogPostService.GetAllBlogsByPage(page,size);
        modelMap.addAttribute("blogs_list",blogs_list);
        modelMap.addAttribute("pages",new int[blogs_list.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "ArticlesPanel";

    }


    @RequestMapping("/ThatPost")
    public String ThatPost(@RequestParam("id") Long id, ModelMap modelMap){
        _BlogPost_ blog=blogPostService.GetBlogPostById(id);
        List<_Comment_> comments = commentService.getAllCommentsOfPost(id);
        System.out.println(comments.size());
        modelMap.addAttribute("blogView",blog);
        modelMap.addAttribute("comments",comments);
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

    @RequestMapping(value = {"/index", "/"})
    public String index(ModelMap modelMap){
        List<_BlogPost_> blogs_list=blogPostService.getRecentBlogPosts(3);
       modelMap.addAttribute("post_list",blogs_list);
        return "index";
    }


    @RequestMapping(value = "/PostOf")
    public String PostOf(@RequestParam("id") Long categoryId, ModelMap modelMap) {
        // Get blog posts for the specified category
        List<_BlogPost_> blogs_list = blogPostService.getBlogPostsByCategory(categoryId);
        System.out.println(blogs_list.size());
        // Check if any posts were found for the category
        if (blogs_list.isEmpty()) {
            // Add a message indicating no posts found
            modelMap.addAttribute("message", "No blog posts found for this category.");
        } else {
            modelMap.addAttribute("post_list", blogs_list);
        }
        // Return the view name (replace "index" with your actual view name)
        return "BlogPostByCategory"; // Update this to your view name for displaying category posts
    }




}
