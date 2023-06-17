package com.test.service;

import com.test.dto.PageableResponse;
import com.test.dto.ProductDto;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto, Integer categoryId);

    ProductDto updateProduct(ProductDto productDto, Integer productId);

    PageableResponse<ProductDto> getAllProduct(int page);

    ProductDto getProductById(Integer productId);

    void deleteProduct(Integer productId);

}
