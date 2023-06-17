package com.test.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Categorys")
public class Category {

    @Id
    private String categoryId;

    @Column(name = "category_title")
    private String title;

    @Column(name = "category_description")
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

}