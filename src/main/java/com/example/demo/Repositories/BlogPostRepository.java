package com.example.demo.Repositories;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Entities._Category_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<_BlogPost_,Long> {
    List<_BlogPost_> findByCategoryId(Long categoryId);
}
