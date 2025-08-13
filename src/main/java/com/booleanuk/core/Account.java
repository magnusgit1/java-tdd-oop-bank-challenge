package com.booleanuk.core;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public double getBalance(){
        double balance = 0.0;
        for (Map.Entry<String, List<Integer>> entry : transactions.entrySet()) {
            List<Integer> value = entry.getValue();
            for (int trans : value) {
                balance += trans;
            }
        }
        return balance;
    }

    public String getBranch(){
        return this.branch;
    }

    public HashMap<String, List<Integer>> getTransactions(){
        return this.transactions;
    }

    public boolean deposit(int amount){
        if (amount < 0) { return false; }

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
        if (amount > getBalance()) { return false; }

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

    public String generateStatement(){
        StringBuilder res = new StringBuilder();
        String start = "|"  + "Date     " + "   |" + "Deposit" + "   |" + "Withdraw" +"  |" + "Balance" + "   |\n";
        res.append(start);
        double total = 0;
        for (Map.Entry<String, List<Integer>> entry : transactions.entrySet()) {
            String date = entry.getKey();
            List<Integer> value = entry.getValue();
            for (int trans : value) {
                total += trans;
                String curr;
                if (trans > 0) {
                    curr = "|"  + date + "   |" + trans + "       |          |" + total + "     |\n";
                } else {
                    curr = "|"  + date + "   |" +  "          |" + trans + "      |" + total + "     |\n";
                }
                res.append(curr);
            }
        }
        return res.toString();
    }
}
