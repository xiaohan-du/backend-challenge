package com.example.backendchallange.service;

import com.example.backendchallange.data.LoanRepository;
import com.example.backendchallange.domain.Loan;
import com.example.backendchallange.service.message.LoanRequest;
import com.example.backendchallange.service.message.LoanResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{
    private final LoanRepository loanRepository;
    public LoanServiceImpl(LoanRepository repository) { this.loanRepository = repository; }

    @Override
    public LoanResponse getLoans(LoanRequest loanRequest) {
        List<Loan> loans = loanRepository.getLoans();
        List<LoanDto> loanDtos = LoanAssembler.toDto(loans);
        return LoanResponse
                .of()
                .loanRequest(loanRequest)
                .loans(loanDtos)
                .build();
    }
}
