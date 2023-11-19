package com.example.backendchallange;

import com.example.backendchallange.data.LoanRepository;
import com.example.backendchallange.data.LoanRepositoryImpl;
import com.example.backendchallange.domain.Loan;
import com.example.backendchallange.domain.Schedule;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;

public class LoanMockRepo {
    private LoanRepository loanRepository = mock(LoanRepositoryImpl.class);
    private Loan loan1 = new Loan(
            1,
            100.0,
            200.0,
            15.0,
            2000.0
    );
    private Loan loan2 = new Loan(
            2,
            200.0,
            400.0,
            25.0,
            4000.0
    );
    // Without balloon payment
    private Schedule schedule1 = new Schedule(
            1,
            0.0,
            0.075,
            12,
            20000.0
    );
    // With balloon payment
    private Schedule schedule2 = new Schedule(
            1,
            10000.0,
            0.075,
            12,
            20000.0
    );
    @Test
    public void shouldGetLoans() {
        // GIVEN
        given(loanRepository.getLoans()).willReturn(List.of(loan1, loan2));
        // WHEN
        List<Loan> loans = loanRepository.getLoans();
        // THEN
        assertEquals(2, loans.size());
        assertEquals(loan1, loans.get(0));
        assertEquals(loan2, loans.get(1));
    }

    @Test
    public void shouldReturnCorrectMonthlyPayment() {
        // GIVEN
        given(loanRepository.calculateMonthlyPayment(schedule1)).willReturn(1735.15);
        // WHEN
        Double monthlyPayment1 = loanRepository.calculateMonthlyPayment(schedule1);
        // THEN
        assertEquals(monthlyPayment1, Double.valueOf(1735.15));
        //GIVEN
        given(loanRepository.calculateMonthlyPayment(schedule2)).willReturn(930.07);
        // WHEN
        Double monthlyPayment2 = loanRepository.calculateMonthlyPayment(schedule2);
        // THEN
        assertEquals(monthlyPayment2, Double.valueOf(930.07));
    }

    @Test
    public void shouldReturnCorrectLoans() {
        // GIVEN
        given(loanRepository.calculateLoans(schedule1)).willReturn(List.of(loan1, loan2));
        // WHEN
        List<Loan> loans = loanRepository.calculateLoans(schedule1);
        // THEN
        assertEquals(2, loans.size());
        assertEquals(loan1, loans.get(0));
        assertEquals(loan2, loans.get(1));
    }
}
