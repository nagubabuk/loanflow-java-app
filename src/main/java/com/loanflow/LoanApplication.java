package com.loanflow;

import java.math.BigDecimal;
import java.util.Objects;

public class LoanApplication {
    private final String applicationId;
    private final BigDecimal principal;
    private LoanStatus status;

    public LoanApplication(String applicationId, BigDecimal principal){
        if(applicationId == null  || applicationId.isBlank()){
            throw new IllegalArgumentException("Application ID cannot be blank");
        }

        Objects.requireNonNull(principal,"Principal cannot be null");

        if(principal.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Principal must be greater than zero");
        }

        this.applicationId =applicationId;
        this.principal = principal;
        this.status = LoanStatus.PENDING;
    }

    public String getApplicationId(){
        return applicationId;
    }

    public BigDecimal getPrincipal(){
        return principal;
    }

    public LoanStatus getStatus(){
        return status;
    }

    public void approve(){
        if(status != LoanStatus.PENDING){
            throw new IllegalStateException("Only pending application can be rejected");
        }
        status = LoanStatus.APPROVED;
    }

   public void reject() {
        if (status != LoanStatus.PENDING) {
            throw new IllegalStateException(
                    "Only pending applications can be rejected");
        }

        status = LoanStatus.REJECTED;
    }
}