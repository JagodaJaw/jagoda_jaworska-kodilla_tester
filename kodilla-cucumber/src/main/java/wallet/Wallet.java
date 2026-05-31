package wallet;

public class Wallet {
    private int balance = 0;

    public Wallet() {
    }

    public void deposit(int money) {
        if (money > 0) {
            this.balance += money;
        }
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public int getBalance() {
        return balance;
    }
}
