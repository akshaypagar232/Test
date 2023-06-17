package com.test.service;

import com.test.dto.CategoryDto;
import com.test.dto.PageableResponse;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    PageableResponse<CategoryDto> getAllCategory(int page);

    CategoryDto getCategoryById(Integer categoryId);

    void deleteCategory(Integer categoryId);

}
