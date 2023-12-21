package com.deepak.kamboj.MoneyManager.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private String name;
    private Long parent;
}
