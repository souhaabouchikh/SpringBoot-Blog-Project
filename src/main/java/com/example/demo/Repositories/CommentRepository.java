package com.example.demo.Repositories;

import com.example.demo.Entities._Comment_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<_Comment_,Long> {
    List<_Comment_> findByBlogPostId(Long blogPostId); // Custom query method


}
