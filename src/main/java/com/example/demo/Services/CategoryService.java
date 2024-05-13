package com.example.demo.Services;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Entities._Category_;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    _Category_ SaveCategory(_Category_ category);
    _Category_ GetCategoryById(long id);
    _Category_ updateCategory(_Category_ category);
    void deleteCategoryById(long id);
    void deleteAllCategories();
    List<_Category_> getAllCategories();
    Page<_Category_> GetAllCategoriesByPage(int page, int size);
    void updateCategorySelective(Long categoryId, String name, String description, String updatedAt);
}
