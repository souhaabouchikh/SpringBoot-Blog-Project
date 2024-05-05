package com.example.demo.Services;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Entities._Category_;
import com.example.demo.Repositories.BlogPostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
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


}
