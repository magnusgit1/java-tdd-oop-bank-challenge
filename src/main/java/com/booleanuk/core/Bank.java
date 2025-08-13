package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final List<Account> allAccounts;
    private int idIncrementer;

    public Bank(String name){
        this.name = name;
        this.allAccounts = new ArrayList<>();
        this.idIncrementer = 1;
    }

    public Account createCurrentAccount(Customer customer){
        Account newAccount = new CurrentAccount(customer.getBranch(), idIncrementer);
        this.idIncrementer++;
        return newAccount;
    }

    public Account createSavingsAccount(Customer customer){
        Account newAccount = new SavingsAccount(customer.getBranch(), idIncrementer);
        this.idIncrementer++;
        return newAccount;
    }

    /*
    public boolean generateStatement(Account account){

    }

     */
}
