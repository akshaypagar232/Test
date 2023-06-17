package com.test.service;

import com.test.dto.CategoryDto;
import com.test.dto.PageableResponse;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, String categoryId);

    PageableResponse<CategoryDto> getAllCategory(int page);

    CategoryDto getCategoryById(String categoryId);

    void deleteCategory(String categoryId);

}
