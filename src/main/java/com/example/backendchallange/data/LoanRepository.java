package com.example.backendchallange.data;

import com.example.backendchallange.domain.Loan;
import com.example.backendchallange.domain.Schedule;

import java.util.List;

public interface LoanRepository {
    List<Loan> getLoans();
    Double calculateMonthlyPayment(Schedule schedule);
    List<Loan> calculateLoans(Schedule schedule);
    void addNewLoan(Loan loan);
}
