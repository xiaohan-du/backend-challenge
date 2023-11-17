package com.example.backendchallange.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Loan {
    @Id
    private Integer id;
    private Double payment;
    private Double principal;
    private Double interest;
    private Double balance;
}
