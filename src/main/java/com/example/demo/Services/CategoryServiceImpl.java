package com.example.demo.Services;

import com.example.demo.Entities._Category_;
import com.example.demo.Repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public _Category_ SaveCategory(_Category_ category) {
        return categoryRepository.save(category);
    }

    @Override
    public _Category_ GetCategoryById(long id) {
       return categoryRepository.findById(id).get();
    }

    @Override
    public _Category_ updateCategory(_Category_ category) {
        return categoryRepository.save(category);
    }


    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }

    @Override
    public List<_Category_> getAllCategories() {
       return categoryRepository.findAll();
    }

    @Override
    public Page<_Category_> GetAllCategoriesByPage(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public void updateCategorySelective(Long categoryId, String name, String description, String updatedAt) {
        Optional<_Category_> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            _Category_ category = optionalCategory.get();
            if (name != null && !name.isEmpty()) {
                category.setName(name);
            }
            if (description != null && !description.isEmpty()) {
                category.setContent(description);
            }
            category.setUpdated_At(String.valueOf(LocalDateTime.parse(updatedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            categoryRepository.save(category);
        } else {
            // Handle case where category with ID not found (throw exception or log error)
            throw new EntityNotFoundException("Category with ID " + categoryId + " not found");
        }
    }

}
