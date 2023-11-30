Feature: login swag labs

  Scenario: login

    Given user goes to "https://www.saucedemo.com/"
    When user login with the following credential
      | username | standard_user |
      | password | secret_sauce  |
    Then login should be succesfull
    And sort the product Z to A

