package com.loanflow;
import java.util.List;

public interface LoanSearchService {
    List<LoanApplication> findByStatus(
        List<LoanApplication> loans,
        LoanStatus status
    );
    
} 