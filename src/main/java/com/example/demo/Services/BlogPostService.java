package com.example.demo.Services;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Entities._Category_;
import com.example.demo.Entities._Comment_;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogPostService {
    _BlogPost_ SaveBlogPost(_BlogPost_ blogPost);
    _BlogPost_ GetBlogPostById(long id);
    _BlogPost_ updateBlogPost(_BlogPost_ blogPost);
    void deleteBlogPostById(long id);
    void deleteAllBlogPosts();
    List<_BlogPost_> getAllBlogPosts();
    public List<_BlogPost_> getRecentBlogPosts(int limit);
    Page<_BlogPost_> GetAllBlogsByPage(int page, int size);
    void updateBlogPostSelective(Long blogId, String title, String content, String updatedAt);
    List<_BlogPost_> getBlogPostsByCategory(Long categoryId);
}
