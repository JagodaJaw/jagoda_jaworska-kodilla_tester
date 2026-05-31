package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletSteps {
    private final Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();

    @Given("I have deposited ${int} in my wallet")
    public void i_have_deposited_money_in_my_wallet(int amount) {
        wallet.deposit(amount);
        assertEquals(amount, wallet.getBalance(), "Incorrect wallet balance");
    }

    @When("I request ${int}")
    public void i_request_money(int amount) {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, amount);
    }

    @Then("${int} should be dispensed")
    public void money_should_be_dispensed(int amount) {
        assertEquals(amount, cashSlot.getContents());
    }

    @Then("the balance of my wallet should be ${int}")
    public void the_balance_of_my_wallet_should_be(int balance) {
        assertEquals(balance, wallet.getBalance());
    }
}
