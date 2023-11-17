package com.example.backendchallange.api.json;

import com.example.backendchallange.service.LoanDto;

import java.util.List;
import java.util.stream.Collectors;

public class LoanJsonAssembler {
    public static LoanJson toLoanJson(LoanDto loanDto) {
        return LoanJson
                .of()
                .id(loanDto.getId())
                .payment(loanDto.getPayment())
                .principal(loanDto.getPrincipal())
                .interest(loanDto.getInterest())
                .balance(loanDto.getBalance())
                .build();
    }

    public static List<LoanJson> toLoanJsonList(List<LoanDto> loanDtoList) {
        return loanDtoList
                .stream()
                .map(l -> LoanJsonAssembler.toLoanJson(l))
                .collect(Collectors.toList());
    }

}
