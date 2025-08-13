package com.booleanuk.core;

public class Customer {
    private final Bank bank;
    private final String name;
    private final String branch;
    private SavingsAccount savingsAccount = null;
    private CurrentAccount currentAccount = null;

    public Customer(Bank bank, String name, String branch){
        this.bank = bank;
        this.name = name;
        this.branch = branch;
    }

    public String getName(){
        return this.name;
    }

    public String getBranch(){
        return this.branch;
    }

    public SavingsAccount getSavingsAccount(){
        return this.savingsAccount;
    }

    public CurrentAccount getCurrentAccount(){
        return this.currentAccount;
    }

    public boolean createCurrentAccount(){
        if (currentAccount != null){ return false; }

        Account newAccount = this.bank.createCurrentAccount(this);
        this.currentAccount = (CurrentAccount) newAccount;
        return currentAccount != null;
    }

    public boolean createSavingsAccount(){
        if (savingsAccount != null) { return false; }

        Account newAccount = this.bank.createSavingsAccount(this);
        this.savingsAccount = (SavingsAccount) newAccount;
        return savingsAccount != null;
    }

    /*
    public boolean deposit(Account account, int amount){

    }

    public boolean withdraw(Account account, int amount){

    }

     */
}
