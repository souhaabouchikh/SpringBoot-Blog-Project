package com.example.demo.Services;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Entities._Category_;
import com.example.demo.Entities._Comment_;
import com.example.demo.Repositories.BlogPostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public _BlogPost_ SaveBlogPost(_BlogPost_ blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public _BlogPost_ GetBlogPostById(long id) {
        return blogPostRepository.findById(id).get();
    }

    @Override
    public _BlogPost_ updateBlogPost(_BlogPost_ blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public void deleteBlogPostById(long id) {
        blogPostRepository.deleteById(id);
    }

    @Override
    public void deleteAllBlogPosts() {
        blogPostRepository.deleteAll();
    }

    @Override
    public List<_BlogPost_> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }


    @Override
    public List<_BlogPost_> getRecentBlogPosts(int limit) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<_BlogPost_> criteriaQuery = criteriaBuilder.createQuery(_BlogPost_.class);
        Root<_BlogPost_> root = criteriaQuery.from(_BlogPost_.class);

        // Order by createdAt descending
        criteriaQuery.select(root)
                .orderBy(criteriaBuilder.desc(root.get("Id")));

        // Create a JPA Query object from the CriteriaQuery
        Query query = entityManager.createQuery(criteriaQuery);

        // Set the limit using setMaxResults
        query.setMaxResults(limit);

        // Execute the query and retrieve results
        List<_BlogPost_> recentPosts = query.getResultList();
        return  recentPosts;
    }

    @Override
    public Page<_BlogPost_> GetAllBlogsByPage(int page, int size) {
        return blogPostRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public void updateBlogPostSelective(Long blogId, String title, String content, String updatedAt) {
        Optional<_BlogPost_> existingPost = blogPostRepository.findById(blogId);
        if (existingPost.isPresent()) {
            _BlogPost_ blogPostToUpdate = existingPost.get();

            // Update fields only if values are provided
            if (title != null && !title.isEmpty()) {
                blogPostToUpdate.setTitle(title);
            }
            if (content != null && !content.isEmpty()) {
                blogPostToUpdate.setContent(content);
            }

            // Parse and update updatedAt if provided
            if (updatedAt != null && !updatedAt.isEmpty()) {
                try {
                    LocalDateTime updatedDateTime = LocalDateTime.parse(updatedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    blogPostToUpdate.setUpdated_At(String.valueOf(updatedDateTime));
                } catch (Exception e) {
                    // Handle parsing exception (e.g., log error)
                    System.out.println("Error parsing updated date: " + e.getMessage());
                }
            }

            // Save the updated blog post
            blogPostRepository.save(blogPostToUpdate);
        } else {
            // Handle case where blog post with ID not found (throw exception or log error)
            throw new EntityNotFoundException("Blog post with ID " + blogId + " not found");
        }
    }
    @Override
    public List<_BlogPost_> getBlogPostsByCategory(Long categoryId) {
        // Replace with your actual logic to filter by category
        return blogPostRepository.findByCategoryId(categoryId);
    }




}
