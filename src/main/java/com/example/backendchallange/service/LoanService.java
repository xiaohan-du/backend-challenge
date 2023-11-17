package com.example.backendchallange.service;

import com.example.backendchallange.service.message.LoanRequest;
import com.example.backendchallange.service.message.LoanResponse;

import java.util.List;

public interface LoanService {
    LoanResponse getLoans(LoanRequest loanRequest);
}
