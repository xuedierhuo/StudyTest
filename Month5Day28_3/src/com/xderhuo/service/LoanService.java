package com.xderhuo.service;

import com.xderhuo.domain.Loan;

import java.util.List;

public interface LoanService {
    void addLoan(Loan loan);

    List<Loan> findLoanByUid(String uid);
}
