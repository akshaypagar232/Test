package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    private Integer productId;
    @Column(name = "product_title")
    private String title;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_price")
    private long price;
    @Column(name = "product_quantity")
    private long quantity;
    @ManyToOne
    private Category category;

}
