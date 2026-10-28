
package com.loanflow;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LoanApplicationTest {

    @Test
    void shouldCreatePendingLoanApplication() {
        LoanApplication loan = new LoanApplication(
                "LN-1001",
                new BigDecimal("125000.50"));

        assertEquals("LN-1001", loan.getApplicationId());

        assertEquals(
                0,
                loan.getPrincipal().compareTo(
                        new BigDecimal("125000.50")));

        assertEquals(LoanStatus.PENDING, loan.getStatus());
    }

    @Test
    void shouldRejectNegativePrincipal() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new LoanApplication(
                        "LN-1002",
                        new BigDecimal("-1000")));
    }

    @Test
    void shouldRejectBlankApplicationId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new LoanApplication(
                        " ",
                        new BigDecimal("1000")));
    }

    @Test
    void shouldRejectZeroPrincipal() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new LoanApplication(
                        "LN-1003",
                        BigDecimal.ZERO));
    }

    @Test
    void shouldApprovePendingApplication() {
        LoanApplication loan = new LoanApplication(
                "LN-1004",
                new BigDecimal("50000"));

        loan.approve();

        assertEquals(LoanStatus.APPROVED, loan.getStatus());
    }

    @Test
    void shouldNotApproveApplicationTwice() {
        LoanApplication loan = new LoanApplication(
                "LN-1005",
                new BigDecimal("50000"));

        loan.approve();

        assertThrows(
                IllegalStateException.class,
                loan::approve);
    }
}
