package com.test.dto;

import com.test.entity.Product;
import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotEmpty
    private String categoryId;

    @NotEmpty
    private String title;

    @NotEmpty
    @Size(max = 50,message = "description size must be max : 50")
    private String description;

    @NotEmpty
    private List<Product> products = new ArrayList<>();

}