package com.deepak.kamboj.MoneyManager.services;

import com.deepak.kamboj.MoneyManager.model.Category;
import com.deepak.kamboj.MoneyManager.model.CategoryRequest;
import com.deepak.kamboj.MoneyManager.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) throws Exception{
        categoryRepository.save(category);
        return categoryRepository.findCategoryById(category.getId());

    }

    public Category getCategory(Long id){
        return categoryRepository.findCategoryById(id);
    }
    public List<Category> getAllCategories () { return categoryRepository.findAll(); }
    public List<Category> getChildCategories(Long id){
        return categoryRepository.findCategoriesByParentId(id);
    }

}
