package com.example.backendchallange.service;

import com.example.backendchallange.domain.Loan;

import java.util.List;
import java.util.stream.Collectors;

public class LoanAssembler {
    public static List<LoanDto> toDto(List<Loan> loans) {
        return loans.stream().map(c -> toDto(c)).collect(Collectors.toList());
    }

    public static LoanDto toDto(Loan loan) {
        return new LoanDto(
                loan.getId(),
                loan.getPayment(),
                loan.getPrincipal(),
                loan.getInterest(),
                loan.getBalance()
        );
    }
}
