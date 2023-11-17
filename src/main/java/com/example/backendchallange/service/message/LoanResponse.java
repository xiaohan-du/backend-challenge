package com.example.backendchallange.service.message;

import com.example.backendchallange.service.LoanDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class LoanResponse {
    private final LoanRequest loanRequest;
    private List<LoanDto> loans;
    private LoanDto loanDto;
}
