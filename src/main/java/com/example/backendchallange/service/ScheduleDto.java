package com.example.backendchallange.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ScheduleDto {
    private Integer id;
    private Double balloonPayment;
    private Double yearlyInterestRate;
    private Integer repayMonths;
    private Double assetCost;
}
