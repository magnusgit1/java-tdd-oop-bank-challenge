package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    public void testWithdraw(){

    }

    @Test
    public void testGenerateStatement(){

    }
}
