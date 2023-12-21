package com.deepak.kamboj.MoneyManager.repositories;

import com.deepak.kamboj.MoneyManager.model.Category;
import com.deepak.kamboj.MoneyManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findCategoryById(Long id);
    @Query("SELECT c FROM Category c WHERE c.parent.id = :id")
    public List<Category> findCategoriesByParentId(@Param("id") Long id);
}
