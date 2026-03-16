package com.kodilla.bank.homework;

public class CashMachine {

    private int[] transactions;
    private int size;

    public CashMachine() {
        this.transactions = new int[0];
        this.size = 0;
    }

    public void addTransaction(int value) {

        if (value == 0) {
            return;
        }

        size++;
        int[] newTab = new int[size];

        for (int i = 0; i < transactions.length; i++) {
            newTab[i] = transactions[i];
        }

        newTab[size - 1] = value;
        transactions = newTab;
    }

    public int getBalance() {
        int sum = 0;

        for (int i = 0; i < transactions.length; i++) {
            sum += transactions[i];
        }

        return sum;
    }

    public int getTransactionsCount() {
        return transactions.length;
    }

    public int[] getTransactions() {
        return transactions;
    }

    public int getDepositCount() {
        int count = 0;

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] > 0) {
                count++;
            }
        }

        return count;
    }

    public int getWithdrawalCount() {
        int count = 0;

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] < 0) {
                count++;
            }
        }

        return count;
    }

    public int getDepositSum() {
        int sum = 0;

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] > 0) {
                sum += transactions[i];
            }
        }

        return sum;
    }

    public int getWithdrawalSum() {
        int sum = 0;

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] < 0) {
                sum += transactions[i];
            }
        }

        return sum;
    }

    public double getAverageDeposit() {
        int count = getDepositCount();

        if (count == 0) {
            return 0;
        }

        return (double) getDepositSum() / count;
    }

    public double getAverageWithdrawal() {
        int count = getWithdrawalCount();

        if (count == 0) {
            return 0;
        }

        return (double) getWithdrawalSum() / count;
    }
}