package com.example.backendchallange.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class LoanDto {
    private Integer id;
    private Double payment;
    private Double principal;
    private Double interest;
    private Double balance;
}
