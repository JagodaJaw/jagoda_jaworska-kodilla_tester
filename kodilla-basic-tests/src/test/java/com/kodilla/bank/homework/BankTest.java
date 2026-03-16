package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTestSuite {

    @Test
    void shouldReturnZeroBalanceWhenNoMachines() {
        Bank bank = new Bank();

        int balance = bank.getTotalBalance();

        assertEquals(0, balance);
    }

    @Test
    void shouldCalculateTotalBalanceFromAllMachines() {
        CashMachine machine1 = new CashMachine();
        machine1.addTransaction(100);
        machine1.addTransaction(-20);

        CashMachine machine2 = new CashMachine();
        machine2.addTransaction(200);
        machine2.addTransaction(-50);

        Bank bank = new Bank();
        bank.addCashMachine(machine1);
        bank.addCashMachine(machine2);

        int balance = bank.getTotalBalance();

        assertEquals(230, balance);
    }

    @Test
    void shouldCalculateDepositCount() {
        CashMachine machine = new CashMachine();
        machine.addTransaction(100);
        machine.addTransaction(50);
        machine.addTransaction(-20);

        Bank bank = new Bank();
        bank.addCashMachine(machine);

        int deposits = bank.getDepositCount();

        assertEquals(2, deposits);
    }

    @Test
    void shouldCalculateWithdrawalCount() {
        CashMachine machine = new CashMachine();
        machine.addTransaction(-30);
        machine.addTransaction(-10);
        machine.addTransaction(50);

        Bank bank = new Bank();
        bank.addCashMachine(machine);

        int withdrawals = bank.getWithdrawalCount();

        assertEquals(2, withdrawals);
    }

    @Test
    void shouldCalculateAverageDeposit() {
        CashMachine machine = new CashMachine();
        machine.addTransaction(100);
        machine.addTransaction(200);

        Bank bank = new Bank();
        bank.addCashMachine(machine);

        double average = bank.getAverageDeposit();

        assertEquals(150, average);
    }

    @Test
    void shouldCalculateAverageWithdrawal() {
        CashMachine machine = new CashMachine();
        machine.addTransaction(-100);
        machine.addTransaction(-300);

        Bank bank = new Bank();
        bank.addCashMachine(machine);

        double average = bank.getAverageWithdrawal();

        assertEquals(-200, average);

    }
}