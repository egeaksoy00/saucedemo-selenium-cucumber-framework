Feature: Login functionality

  @smoke
  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters valid username and password
    Then user should be redirected to the products page

  @regression
  Scenario: Unsuccessful login with invalid credentials
    Given user is on the login page
    When user enters invalid username and password
    Then user should see an error message

  @regression
  Scenario: Add product to cart after login
    Given user is on the login page
    When user enters valid username and password
    And user adds a product to the cart
    Then user should see the product in the cart

  @smoke @regression
  Scenario: Complete checkout successfully
    Given user is on the login page
    When user enters valid username and password
    And user adds a product to the cart
    And user proceeds to checkout
    And user enters checkout information
    Then user should complete the checkout successfully

  @regression
  Scenario Outline: Login with multiple credential sets
    Given user is on the login page
    When user enters username "<username>" and password "<password>"
    Then login result should be "<result>"

    Examples:
      | username        | password     | result  |
      | standard_user   | secret_sauce | success |
      | locked_out_user | secret_sauce | error   |
      | wrong_user      | wrong_pass   | error   |