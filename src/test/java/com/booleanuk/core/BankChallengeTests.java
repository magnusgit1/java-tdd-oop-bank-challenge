package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class BankChallengeTests {

    @Test
    public void testAccountCreation(){
        Bank bank = new Bank("Nordea");

        Customer jim = new Customer(bank, "Jim", "NewYork");
        Customer bob = new Customer(bank, "Bob", "Oslo");

        jim.createCurrentAccount();
        bob.createCurrentAccount();

        // Ids should be different
        Assertions.assertTrue(jim.getCurrentAccount().getId() != bob.getCurrentAccount().getId());
        // Customers should only be able to create 1 current account and 1 savings account
        Assertions.assertFalse(jim.createCurrentAccount());
        Assertions.assertTrue(bob.createSavingsAccount());
        Assertions.assertEquals(1, jim.getCurrentAccount().getId());
    }

    @Test
    public void testDeposit(){
        Bank bank = new Bank("DNB");

        Customer jim = new Customer(bank, "Jim", "Ohio");
        Customer bob = new Customer(bank, "Bob", "Nevada");

        jim.createCurrentAccount();
        bob.createSavingsAccount();

        LocalDateTime time = LocalDateTime.now();
        String day = String.valueOf(time.getDayOfMonth());
        String month = String.valueOf(time.getMonthValue());
        String year = String.valueOf(time.getYear());
        String date = day + "/" + month + "/" + year;

        jim.deposit(jim.getCurrentAccount(), 500);
        jim.deposit(jim.getCurrentAccount(), 200);

        Assertions.assertEquals(2, jim.getCurrentAccount().getTransactions().get(date).size());

        Assertions.assertEquals(700, jim.getCurrentAccount().getBalance());
        Assertions.assertEquals(0, bob.getSavingsAccount().getBalance());
        Assertions.assertFalse(jim.withdraw(jim.getCurrentAccount(), 900));
        Assertions.assertTrue(jim.withdraw(jim.getCurrentAccount(), 600));
        Assertions.assertTrue(jim.deposit(jim.getCurrentAccount(), 100));
    }

    @Test
    public void testWithdraw(){

    }

    @Test
    public void testGenerateStatement(){

    }
}
