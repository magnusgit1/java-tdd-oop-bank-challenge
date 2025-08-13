package com.booleanuk.core;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final List<Account> allAccounts;
    private int idIncrementer;
    Manager manager;

    public Bank(String name, Manager manager){
        this.name = name;
        this.allAccounts = new ArrayList<>();
        this.idIncrementer = 1;
        this.manager = manager;
    }

    public String getName(){
        return this.name;
    }

    public List<Account> getAllAccounts(){
        return this.allAccounts;
    }

    public Account createCurrentAccount(Customer customer){
        Account newAccount = new CurrentAccount(customer.getBranch(), idIncrementer, manager);
        allAccounts.add(newAccount);
        this.idIncrementer++;
        return newAccount;
    }

    public Account createSavingsAccount(Customer customer){
        Account newAccount = new SavingsAccount(customer.getBranch(), idIncrementer, manager);
        allAccounts.add(newAccount);
        this.idIncrementer++;
        return newAccount;
    }
}
