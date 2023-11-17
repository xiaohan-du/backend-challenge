package com.example.backendchallange.data;

import com.example.backendchallange.domain.Loan;

import java.util.List;

public interface LoanRepository {
    List<Loan> getLoans();
}
