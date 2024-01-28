package com.deepak.kamboj.MoneyManager.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    public int errorCode;
    public String errorMessage;
}
