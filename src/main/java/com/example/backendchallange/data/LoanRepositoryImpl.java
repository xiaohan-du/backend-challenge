package com.example.backendchallange.data;

import com.example.backendchallange.domain.Loan;
import com.example.backendchallange.domain.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanRepositoryImpl implements LoanRepository {
    private final JdbcTemplate loanJdbcTemplate;
    private RowMapper<Loan> loanRowMapper;

    public LoanRepositoryImpl(JdbcTemplate aLoanJdbcTemplate) {
        this.loanJdbcTemplate = aLoanJdbcTemplate;
        setLoanRowMapper();
    }

    private void setLoanRowMapper() {
        loanRowMapper = (rm, index) -> new Loan(
                rm.getInt("id"),
                rm.getDouble("payment"),
                rm.getDouble("principal"),
                rm.getDouble("interest"),
                rm.getDouble("balance")
        );
    }

    @Override
    public List<Loan> getLoans() {
        String getLoanSQL = "SELECT * FROM loan";
        return loanJdbcTemplate.query(getLoanSQL, loanRowMapper);
    }

    @Override
    public Double calculateMonthlyPayment(Schedule schedule) {
        Double monthlyInterestRate = schedule.getYearlyInterestRate() / schedule.getRepayMonths();
        Double operatorA;
        Double operatorB;
        Double monthlyPayment;
        if (schedule.getBalloonPayment() == 0) {
            operatorA = monthlyInterestRate * Math.pow((1 + monthlyInterestRate), schedule.getRepayMonths());
            operatorB = (Math.pow((1 + monthlyInterestRate), schedule.getRepayMonths()) - 1);
            monthlyPayment = schedule.getAssetCost() * (operatorA / operatorB);
        } else {
            operatorA = schedule.getAssetCost() - (schedule.getBalloonPayment() / Math.pow((1 + monthlyInterestRate), schedule.getRepayMonths()));
            operatorB = monthlyInterestRate / (1 - Math.pow((1 + monthlyInterestRate), -schedule.getRepayMonths()));
            monthlyPayment = operatorA * operatorB;
        }
        return monthlyPayment;
    }

    @Override
    public List<Loan> calculateLoans(Schedule schedule) {
        Double payment = calculateMonthlyPayment(schedule);
        List<Loan> loans = new ArrayList<>();
        Double monthlyInterestRate = schedule.getYearlyInterestRate() / schedule.getRepayMonths();
        Double balance = schedule.getAssetCost();
        for (int i = 1; i <= schedule.getRepayMonths(); i++) {
            Double interest = balance * monthlyInterestRate;
            Double principal = payment - interest;
            balance = balance + interest - payment;
            Loan loan = new Loan();
            loan.setPayment(payment);
            loan.setPrincipal(principal);
            loan.setInterest(interest);
            loan.setBalance(balance);
            loans.add(loan);
        }
        return loans;
    }

    @Override
    public void addNewLoan(Loan loan) {
        String addALoanSQL = "INSERT INTO loan (payment, principal, interest, balance) VALUES (?, ?, ?, ?)";
        loanJdbcTemplate.update(addALoanSQL, loan.getPayment(), loan.getPrincipal(), loan.getInterest(), loan.getBalance());
    }

}
