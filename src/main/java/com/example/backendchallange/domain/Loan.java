package com.example.backendchallange.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    private Integer id;
    private Double payment;
    private Double principal;
    private Double interest;
    private Double balance;
}
