package com.test.dto;

import com.test.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotEmpty
    private String productId;
    @NotEmpty
    private String title;
    @NotEmpty
    @Size(max = 50, message = "description must be max : 50")
    private String description;
    @NotEmpty
    private long price;
    @NotEmpty
    private long quantity;
    @NotEmpty
    private Category category;

}
