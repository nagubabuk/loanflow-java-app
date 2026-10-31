package com.loanflow;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanSearchServiceTest {

    @Test 
    void shouldReturnOnlyApprovedLoans(){
        LoanApplication loan1 = new LoanApplication("Ln-3001",new BigDecimal("10000"));
        LoanApplication loan2 = new LoanApplication(
                "LN-3002", new BigDecimal("20000"));

        LoanSearchService service = new LoanSearchServiceImpl();
        
        loan2.approve();

        List<LoanApplication> result = service.findByStatus(
                List.of(loan1, loan2),
                LoanStatus.APPROVED);

        assertEquals(1, result.size());
        assertEquals("LN-3002", result.get(0).getApplicationId());
    }
    
}
