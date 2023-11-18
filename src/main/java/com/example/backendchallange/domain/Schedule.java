package com.example.backendchallange.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Schedule {
    @Id
    private Integer id;
    private Double balloonPayment;
    private Double yearlyInterestRate;
    private Double repayMonths;
    private Double assetCost;
}
