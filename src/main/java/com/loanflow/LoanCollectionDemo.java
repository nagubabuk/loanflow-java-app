package com.loanflow;

import java.util.ArrayList;
import java.util.List;

public class LoanCollectionDemo {

    public static void main(String[] args){
        List<String> loanIds = new ArrayList<>();
        loanIds.add("Ln-3001");
        loanIds.add("Ln-3002");
        
        for(String loanId :loanIds){
            System.out.println(loanId);
        }
    }
}