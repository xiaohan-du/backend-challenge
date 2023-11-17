package com.example.backendchallange.data;

import com.example.backendchallange.domain.Loan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
}
