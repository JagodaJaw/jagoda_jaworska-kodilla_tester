package fizzbuzz;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static fizzbuzz.FizzBuzz.check;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzSteps {
    private int number;
    private String answer;

    @Given("the number is {int}")
    public void the_number_is(int number) {
        this.number = number;
    }

    @When("I ask for the FizzBuzz result")
    public void i_ask_for_the_fizz_buzz_result() {
        this.answer = check(this.number);
    }

    @Then("I should get {string}")
    public void i_should_get(String expectedAnswer) {
        assertEquals(expectedAnswer, this.answer);
    }
}
