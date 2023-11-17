package com.example.backendchallange.api.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class LoanJson {
    private Integer id;
    private Double payment;
    private Double principal;
    private Double interest;
    private Double balance;
}
