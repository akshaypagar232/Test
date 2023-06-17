package com.test.service;

import com.test.dto.PageableResponse;
import com.test.dto.ProductDto;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto, String productId);

    PageableResponse<ProductDto> getAllProduct(int page);

    ProductDto getProductById(String productId);

    void deleteProduct(String productId);

}
