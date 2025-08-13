package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Account {
    private final String branch;
    private double balance;
    private final HashMap<String, List<Integer>> transactions;
    private final int id;

    public Account(String branch, int id){
        this.branch = branch;
        this.id = id;
        this.transactions = new HashMap<>();
        this.balance = 0.0;
    }

    public int getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public HashMap<String, List<Integer>> getTransactions(){
        return this.transactions;
    }

    public boolean deposit(int amount){
        if (amount < 0) { return false; }
        this.balance += amount;

        // create transaction
        String date = currentDate();
        if (!transactions.containsKey(date)){
            transactions.put(date, new ArrayList<>(){{add(amount);}});
        } else {
            transactions.get(date).add(amount);
        }
        return true;
    }

    public boolean withdraw(int amount){
        if (amount > this.balance) { return false; }
        this.balance -= amount;

        // create transaction
        String date = currentDate();
        if (!transactions.containsKey(date)){
            transactions.put(date, new ArrayList<>(){{add(-amount);}});
        } else {
            transactions.get(date).add(-amount);
        }
        return true;
    }

    public String currentDate(){
        LocalDateTime time = LocalDateTime.now();

        String day = String.valueOf(time.getDayOfMonth());
        String month = String.valueOf(time.getMonthValue());
        String year = String.valueOf(time.getYear());

        return day + "/" + month + "/" + year;
    }

}
