Feature: Cash Withdrawal

Scenario Outline: Withdrawal from a wallet
      Given I have deposited $<deposit> in my wallet
      When  I request $<amount>
      Then  $<dispensed> should be dispensed
      And   the balance of my wallet should be $<balance>

Examples:
      | deposit | amount | dispensed | balance |
      | 200     | 30     | 30        | 170     |
      | 200     | 200    | 200       | 0       |
      | 200     | 250    | 0         | 200     |
      | 0       | 30     | 0         | 0       |
      | 200     | 0      | 0         | 200     |
