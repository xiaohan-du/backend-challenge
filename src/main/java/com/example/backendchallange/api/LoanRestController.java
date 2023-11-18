package com.example.backendchallange.api;

import com.example.backendchallange.api.json.LoanJson;
import com.example.backendchallange.api.json.LoanJsonAssembler;
import com.example.backendchallange.service.LoanService;
import com.example.backendchallange.service.ScheduleDto;
import com.example.backendchallange.service.message.LoanRequest;
import com.example.backendchallange.service.message.LoanResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class LoanRestController {
    private LoanService loanService;
    public LoanRestController(LoanService loanService) { this.loanService = loanService; }
    @GetMapping("loans")
    public ResponseEntity<List<LoanJson>> getLoans() {
        LoanRequest loanRequest = LoanRequest.of().build();
        LoanResponse loanResponse = loanService.getLoans(loanRequest);
        return ResponseEntity.ok(LoanJsonAssembler.toLoanJsonList(loanResponse.getLoans()));
    }

    @PostMapping("loans/new")
    public ResponseEntity calculateLoans(Integer id, Double balloonPayment, Double yearlyInterestRate, Integer repayMonths, Double assetCost) {
        ScheduleDto scheduleDto = new ScheduleDto(id, balloonPayment, yearlyInterestRate, repayMonths, assetCost);
        loanService.calculateLoans(scheduleDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
