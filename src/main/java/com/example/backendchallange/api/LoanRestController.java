package com.example.backendchallange.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class LoanRestController {
    @GetMapping("details")
    public String getLoanDetails() {
        return "Loan details";
    }
}
