package com.kodilla.bank.homework;

public class Bank {

    private CashMachine[] machines;

    public Bank() {
        this.machines = new CashMachine[0];
    }

    public void addCashMachine(CashMachine machine) {
        CashMachine[] newTab = new CashMachine[machines.length + 1];

        for (int i = 0; i < machines.length; i++) {
            newTab[i] = machines[i];
        }

        newTab[machines.length] = machine;
        machines = newTab;
    }

    public int getTotalBalance() {
        int sum = 0;

        for (int i = 0; i < machines.length; i++) {
            sum += machines[i].getBalance();
        }

        return sum;
    }

    public int getDepositCount() {
        int count = 0;

        for (int i = 0; i < machines.length; i++) {
            count += machines[i].getDepositCount();
        }

        return count;

    }

    public int getWithdrawalCount() {
        int count = 0;

        for (int i = 0; i < machines.length; i++) {
            count += machines[i].getWithdrawalCount();
        }

        return count;
    }

    public double getAverageDeposit() {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < machines.length; i++) {
            sum += machines[i].getDepositSum();
            count += machines[i].getDepositCount();
        }

        if (count == 0) {
            return 0;
        }

        return (double) sum / count;
    }


    public double getAverageWithdrawal() {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < machines.length; i++) {
            sum += machines[i].getWithdrawalSum();
            count += machines[i].getWithdrawalCount();
        }

        if (count == 0) {
            return 0;
        }

        return (double) sum / count;
    }
}