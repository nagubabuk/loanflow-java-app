package com.loanflow;
import  java.util.List;;

public class LoanSearchServiceImpl implements LoanSearchService {

    @Override 
    public List<LoanApplication> findByStatus(
        List<LoanApplication> loans,
        LoanStatus status){
            return  loans.stream()
            .filter(loan ->loan.getStatus()== status)
            .toList();
        };
    
}
