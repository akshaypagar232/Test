package com.test.service.impl;

import com.test.constant.AppConstant;
import com.test.dto.PageableResponse;
import com.test.dto.ProductDto;
import com.test.entity.Category;
import com.test.entity.Product;
import com.test.exception.ResourceNotFoundException;
import com.test.helper.Helper;
import com.test.repository.CategoryRepository;
import com.test.repository.ProductRepository;
import com.test.service.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductDto createProduct(ProductDto productDto, Integer categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.CATEGORY_NOT_FOUND));
        Product product = mapper.map(productDto, Product.class);
        product.setCategory(category);
        Product save = productRepository.save(product);
        ProductDto map = mapper.map(save, ProductDto.class);

        return map;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) {

        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.PRODUCT_NOT_FOUND));
        Product map = mapper.map(productDto, Product.class);
        product.setTitle(map.getTitle());
        product.setDescription(map.getDescription());
        product.setPrice(map.getPrice());
        product.setQuantity(map.getQuantity());
        Product save = productRepository.save(product);
        ProductDto map1 = mapper.map(save, ProductDto.class);

        return map1;
    }

    @Override
    public PageableResponse<ProductDto> getAllProduct(int page) {

        PageRequest pageRequest = PageRequest.of(page, AppConstant.PAGE_SIZE);
        Page<Product> all = productRepository.findAll(pageRequest);
        PageableResponse<ProductDto> pagableResponse = Helper.getPagableResponse(all, ProductDto.class);

        return pagableResponse;
    }

    @Override
    public ProductDto getProductById(Integer productId) {

        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.PRODUCT_NOT_FOUND));
        ProductDto map = mapper.map(product, ProductDto.class);

        return map;
    }

    @Override
    public void deleteProduct(Integer productId) {

        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.PRODUCT_NOT_FOUND));
        productRepository.delete(product);
    }
}
