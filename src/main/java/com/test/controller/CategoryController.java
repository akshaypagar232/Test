package com.test.controller;

import com.test.constant.AppConstant;
import com.test.dto.CategoryDto;
import com.test.dto.PageableResponse;
import com.test.exception.ApiResponse;
import com.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {

        CategoryDto category = categoryService.createCategory(categoryDto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/category/{categoryId}")
    ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable String categoryId) {

        CategoryDto categoryDto1 = categoryService.updateCategory(categoryDto, categoryId);

        return new ResponseEntity<CategoryDto>(categoryDto1, HttpStatus.CREATED);
    }

    @DeleteMapping("/category/{categoryId}")
    ResponseEntity<ApiResponse> deleteCategory(@PathVariable String categoryId) {

        categoryService.deleteCategory(categoryId);

        ApiResponse apiResponse = ApiResponse.builder()
                .message(AppConstant.CATEGORY_DELETE)
                .status(true)
                .success(HttpStatus.OK)
                .build();

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/category")
    ResponseEntity<PageableResponse<CategoryDto>> getAllCategory(@RequestParam int page) {

        PageableResponse<CategoryDto> allCategory = categoryService.getAllCategory(page);

        return new ResponseEntity<>(allCategory, HttpStatus.FOUND);
    }

    @GetMapping("/category/categoryId")
    ResponseEntity<CategoryDto> getCategoryById(@PathVariable String categoryId) {

        CategoryDto categoryById = categoryService.getCategoryById(categoryId);

        return new ResponseEntity<>(categoryById, HttpStatus.FOUND);
    }

}
