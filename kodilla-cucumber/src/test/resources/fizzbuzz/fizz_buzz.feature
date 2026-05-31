Feature: FizzBuzz
  The system should return the correct text depending on whether a number
  is divisible by 3, by 5, by both 3 and 5, or by neither.

Scenario Outline: Check FizzBuzz result for a given number
      Given the number is <number>
      When  I ask for the FizzBuzz result
      Then  I should get "<answer>"

Examples:
      | number | answer   |
      | 3      | Fizz     |
      | 5      | Buzz     |
      | 15     | FizzBuzz |
      | 7      | None     |
      | 9      | Fizz     |
      | 10     | Buzz     |
      | 30     | FizzBuzz |
      | 22     | None     |
