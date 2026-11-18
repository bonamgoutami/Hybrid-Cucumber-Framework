Feature: Login functionality
  Scenario: valid login with correct credentials
    Given user opens browser and navigates to "https://www.saucedemo.com/"
    When user enter username "standard_user" and password "secret_sauce"
    And  user clicks on login button
    Then user should be navigated to products page


  Scenario: invalid login with correct credentials
    Given user opens browser and navigates to "https://www.saucedemo.com/"
    When user enter username "locked_out_user" and password "secret_sauce"
    And  user clicks on login button
    Then error message should be displayed

  Scenario: invalid login with Wrong Password
    Given user opens browser and navigates to "https://www.saucedemo.com/"
    When user enter username "standard_user" and password "secret"
    And  user clicks on login button
    Then error message should be displayed

  Scenario: invalid login with empty credentials
    Given user opens browser and navigates to "https://www.saucedemo.com/"
    When user enter username " " and password "  "
    And  user clicks on login button
    Then error message should be displayed