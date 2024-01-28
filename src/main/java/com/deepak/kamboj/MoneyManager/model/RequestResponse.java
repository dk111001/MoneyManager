package com.deepak.kamboj.MoneyManager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestResponse {
    private int status;
    private String message;
    private Object data;
}
