package com.example.demo.Repositories;

import com.example.demo.Entities._Category_;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<_Category_,Long> {
}
