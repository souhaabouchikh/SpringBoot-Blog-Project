package com.example.demo.Services;

import com.example.demo.Entities._Category_;
import com.example.demo.Repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
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

}
