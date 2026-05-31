package wallet;

public class Cashier {
    private final CashSlot cashSlot;
    private String message = "";

    public Cashier(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdraw(Wallet wallet, int amount) {
        if (wallet.withdraw(amount)) {
            cashSlot.dispense(amount);
            message = "";
        } else {
            message = "You don't have enough money in your wallet";
        }
    }

    public String getMessage() {
        return message;
    }
}
