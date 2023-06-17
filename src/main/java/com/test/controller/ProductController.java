package com.test.controller;

import com.test.constant.AppConstant;
import com.test.dto.PageableResponse;
import com.test.dto.ProductDto;
import com.test.exception.ApiResponse;
import com.test.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {

        ProductDto product = productService.createProduct(productDto);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/product/{productId}")
    ResponseEntity<ProductDto> updateProductDto(@RequestBody ProductDto productDto, @PathVariable String productId) {

        ProductDto product = productService.updateProduct(productDto, productId);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/product")
    ResponseEntity<PageableResponse<ProductDto>> getAllProduct(@RequestParam int page) {

        PageableResponse<ProductDto> allProduct = productService.getAllProduct(page);

        return new ResponseEntity<PageableResponse<ProductDto>>(allProduct, HttpStatus.FOUND);
    }

    @GetMapping("/product/{productId}")
    ResponseEntity<ProductDto> getProductById(@PathVariable String productId) {

        ProductDto productById = productService.getProductById(productId);

        return new ResponseEntity<>(productById, HttpStatus.FOUND);
    }

    @DeleteMapping("/product/{productId}")
    ResponseEntity<ApiResponse> deleteProduct(@PathVariable String productId) {

        productService.deleteProduct(productId);

        ApiResponse response = ApiResponse.builder()
                .message(AppConstant.PRODUCT_DELETE)
                .status(true)
                .success(HttpStatus.OK)
                .build();

        return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }

}
