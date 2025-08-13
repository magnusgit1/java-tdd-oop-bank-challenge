package com.booleanuk.core;

import java.util.HashMap;
import java.util.List;

public abstract class Account {
    private final String branch;
    private final HashMap<String, List<Integer>> transactions;
    private final int id;

    public Account(String branch, int id){
        this.branch = branch;
        this.id = id;
        this.transactions = new HashMap<>();
    }

    public int getId(){
        return this.id;
    }

    public HashMap<String, List<Integer>> getTransactions(){
        return this.transactions;
    }

    /*
    public boolean deposit(int amount){

    }

    public boolean withdraw(int amount){

    }
    */

}
