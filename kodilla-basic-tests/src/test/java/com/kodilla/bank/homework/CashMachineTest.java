package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashMachineTestSuite {

    @Test
    void shouldReturnZeroBalanceWhenNoTransactions() {
        CashMachine machine = new CashMachine();

        int balance = machine.getBalance();

        assertEquals(0, balance);
    }

    @Test
    void shouldCalculateBalanceCorrectly() {
        CashMachine machine = new CashMachine();

        machine.addTransaction(100);
        machine.addTransaction(-50);
        machine.addTransaction(20);

        int balance = machine.getBalance();

        assertEquals(70, balance);
    }

    @Test
    void shouldCountDepositsAndWithdrawals() {
        CashMachine machine = new CashMachine();

        machine.addTransaction(100);
        machine.addTransaction(-30);
        machine.addTransaction(-20);
        machine.addTransaction(50);

        assertEquals(2, machine.getDepositCount());
        assertEquals(2, machine.getWithdrawalCount());
    }

    @Test
    void shouldCalculateDepositSum() {
        CashMachine machine = new CashMachine();

        machine.addTransaction(100);
        machine.addTransaction(50);
        machine.addTransaction(-30);

        int sum = machine.getDepositSum();

        assertEquals(150, sum);
    }

    @Test
    void shouldCalculateWithdrawalSum() {
        CashMachine machine = new CashMachine();

        machine.addTransaction(100);
        machine.addTransaction(-40);
        machine.addTransaction(-10);

        int sum = machine.getWithdrawalSum();

        assertEquals(-50, sum);
    }

    @Test
    void shouldIgnoreZeroTransaction() {

        CashMachine machine = new CashMachine();

        machine.addTransaction(0);

        assertEquals(0, machine.getTransactionsCount());
    }
}