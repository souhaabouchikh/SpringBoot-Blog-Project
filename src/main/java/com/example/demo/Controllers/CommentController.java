package com.example.demo.Controllers;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Entities._Comment_;
import com.example.demo.Security.Entities.User;
import com.example.demo.Security.Services.AccountService;
import com.example.demo.Security.Services.UserDetailServiceImpl;
import com.example.demo.Services.BlogPostService;
import com.example.demo.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    UserDetailServiceImpl userDetailService;
    @Autowired
    AccountService accountService;
    @Autowired
    BlogPostService blogPostService;
    @RequestMapping("SaveComment")
    public String SaveComment(@ModelAttribute("comment") _Comment_ comment, @RequestParam("id") Long id, ModelMap modelMap)
    {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        comment.setCreatedAt(formattedDateTime);
        User user=accountService.GetUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        comment.setUser(user);
        comment.setId(null);
        commentService.SaveComment(comment);

        _BlogPost_ blog=blogPostService.GetBlogPostById(id);
        List<_Comment_> comments = commentService.getAllCommentsOfPost(id);
        System.out.println(comments.size());
        modelMap.addAttribute("blogView",blog);
        modelMap.addAttribute("comments",comments);
        return "post";
    }
}
