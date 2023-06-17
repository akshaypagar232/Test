package com.test.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableResponse<V> {

    private List<V> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPage;
    private boolean lastPage;
}
