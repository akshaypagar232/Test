package com.test.service.impl;

import com.test.constant.AppConstant;
import com.test.dto.CategoryDto;
import com.test.dto.PageableResponse;
import com.test.entity.Category;
import com.test.exception.ResourceNotFoundException;
import com.test.helper.Helper;
import com.test.repository.CategoryRepository;
import com.test.service.CategoryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = mapper.map(categoryDto, Category.class);
        Category save = categoryRepository.save(category);
        CategoryDto map = mapper.map(save, CategoryDto.class);

        return map;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.CATEGORY_NOT_FOUND));
        Category category1 = mapper.map(categoryDto, Category.class);
        category.setTitle(category1.getTitle());
        category.setDescription(category1.getDescription());
        Category save = categoryRepository.save(category);
        CategoryDto map = mapper.map(save, CategoryDto.class);

        return map;
    }

    @Override
    public PageableResponse<CategoryDto> getAllCategory(int page) {

        PageRequest pageRequest = PageRequest.of(page, AppConstant.PAGE_SIZE);
        Page<Category> all = categoryRepository.findAll(pageRequest);
        PageableResponse<CategoryDto> Response = Helper.getPagableResponse(all, CategoryDto.class);

        return Response;
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.CATEGORY_NOT_FOUND));
        CategoryDto map = mapper.map(category, CategoryDto.class);

        return map;
    }

    @Override
    public void deleteCategory(Integer categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.CATEGORY_NOT_FOUND));
        categoryRepository.delete(category);
    }
}
