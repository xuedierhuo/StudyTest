package com.xderhuo.service.impl;

import com.xderhuo.domain.Loan;
import com.xderhuo.mapper.LoanMapper;
import com.xderhuo.service.LoanService;
import com.xderhuo.utils.MyBatisUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class LoanServiceImpl implements LoanService {
    @Override
    public void addLoan(Loan loan) {
        LoanMapper loanMapper = MyBatisUtils.getMapper(LoanMapper.class);
        loanMapper.insert(loan);
        MyBatisUtils.commitAndClose();
    }

    @Override
    public List<Loan> findLoanByUid(String uid) {
        LoanMapper loanMapper = MyBatisUtils.getMapper(LoanMapper.class);
        List<Loan> loans = loanMapper.findLoanByUid(uid);
        MyBatisUtils.close();
        return loans;
    }
}
