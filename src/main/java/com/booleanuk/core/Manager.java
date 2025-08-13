package com.booleanuk.core;

public class Manager {
    String name;
    double draftLimit;

    public Manager(String name, double draftLimit){
        this.name = name;
        this.draftLimit = draftLimit;
    }

    public boolean approveDraft(double amount, double currentBalance){
        return (currentBalance-amount) > draftLimit;
    }
}
