package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletSteps {
    private final Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();
    private final Cashier cashier = new Cashier(cashSlot);
    private int displayedBalance;

    @Given("I have deposited ${int} in my wallet")
    public void i_have_deposited_money_in_my_wallet(int amount) {
        wallet.deposit(amount);
        assertEquals(amount, wallet.getBalance(), "Incorrect wallet balance");
    }

    @Given("there is ${int} in my wallet")
    public void there_is_money_in_my_wallet(int amount) {
        wallet.deposit(amount);
        assertEquals(amount, wallet.getBalance(), "Incorrect wallet balance");
    }

    @When("I request ${int}")
    public void i_request_money(int amount) {
        cashier.withdraw(wallet, amount);
    }

    @When("I withdraw ${int}")
    public void i_withdraw_money(int amount) {
        cashier.withdraw(wallet, amount);
    }

    @When("I check the balance of my wallet")
    public void i_check_the_balance_of_my_wallet() {
        displayedBalance = wallet.getBalance();
    }

    @Then("${int} should be dispensed")
    public void money_should_be_dispensed(int amount) {
        assertEquals(amount, cashSlot.getContents());
    }

    @Then("nothing should be dispensed")
    public void nothing_should_be_dispensed() {
        assertEquals(0, cashSlot.getContents());
    }

    @Then("the balance of my wallet should be ${int}")
    public void the_balance_of_my_wallet_should_be(int balance) {
        assertEquals(balance, wallet.getBalance(), "Incorrect wallet balance");
    }

    @Then("I should be told that I don't have enough money in my wallet")
    public void i_should_be_told_that_i_do_not_have_enough_money_in_my_wallet() {
        assertEquals("You don't have enough money in your wallet", cashier.getMessage());
    }

    @Then("I should see that the balance is ${int}")
    public void i_should_see_that_the_balance_is(int balance) {
        assertEquals(balance, displayedBalance);
    }
}
