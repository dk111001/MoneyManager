package com.deepak.kamboj.MoneyManager.controllers;

import com.deepak.kamboj.MoneyManager.model.Category;
import com.deepak.kamboj.MoneyManager.model.CategoryRequest;
import com.deepak.kamboj.MoneyManager.security.AuthRequest;
import com.deepak.kamboj.MoneyManager.security.AuthResponse;
import com.deepak.kamboj.MoneyManager.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getCategory(){
        List<Category> categories = categoryService.getAllCategories();
        if (!categories.isEmpty()) {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id){
        System.out.println("yee "+id);
        Category category = categoryService.getCategory(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/child")
    public ResponseEntity<?> getChildCategories(@PathVariable Long id){
        System.out.println("yee "+id);
        List<Category> categories = categoryService.getChildCategories(id);
        if (!categories.isEmpty()) {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody Category categoryRequest) {
        System.out.print("yee123!");
//        if (bindingResult.hasErrors()) {
//            // If validation errors exist, return a 400 Bad Request with the error details
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Validation Failed");
//        }

        // Create the category
        try{
            Category createdCategory = categoryService.createCategory(categoryRequest);
            System.out.print("yee123! " + createdCategory.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
        }
        catch (Exception e) {
            System.out.print("error");
            //throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Category not created");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }

        //return ResponseEntity.status(HttpStatus.CREATED).body("Yo");

    }
}
