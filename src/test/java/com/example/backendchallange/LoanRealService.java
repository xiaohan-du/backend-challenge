package com.example.backendchallange;

import com.example.backendchallange.service.LoanService;
import com.example.backendchallange.service.ScheduleDto;
import com.example.backendchallange.service.message.LoanRequest;
import com.example.backendchallange.service.message.LoanResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class LoanRealService {
    @Autowired
    private LoanService loanService;

    @Test
    public void shouldGetZeroLoansWhenServiceStarts() {
        // GIVEN
        LoanRequest loanRequest = LoanRequest.of().build();
        // WHEN
        LoanResponse loanResponse = loanService.getLoans(loanRequest);
        // THEN
        assertEquals(0, loanResponse.getLoans().size());
    }

    @Test
    public void shouldAddLoans() {
        // GIVEN
        ScheduleDto schedule1 = new ScheduleDto(
            1,
                0.0,
                0.075,
                12,
                20000.0
        );
        LoanRequest loanRequest = LoanRequest.of().build();
        loanService.calculateLoans(schedule1);
        // WHEN
        LoanResponse loanResponse = loanService.getLoans(loanRequest);
        // THEN
        assertEquals(12, loanResponse.getLoans().size());
        assertEquals(1735.15, round(loanResponse.getLoans().get(3).getPayment()), 2);
        assertEquals(1640.52, round(loanResponse.getLoans().get(3).getPrincipal()), 2);
        assertEquals(94.62, round(loanResponse.getLoans().get(3).getInterest()), 2);
        assertEquals(13498.77, round(loanResponse.getLoans().get(3).getBalance()), 2);
    }
}
