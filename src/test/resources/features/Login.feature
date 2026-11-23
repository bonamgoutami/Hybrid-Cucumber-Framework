Feature: Login functionality
  Scenario Outline: valid login with different credentials
    Given user opens browser and navigates to "https://www.saucedemo.com/"
    When user enter username "<username>" and password "<password>"
    And  user clicks on login button
    Then user should be navigated to products page
Examples:
    |username                |password    |
    |standard_user           |secret_sauce|
    |problem_user            |secret_sauce|
    |performance_glitch_user |secret_sauce|


  Scenario Outline: invalid login with different credentials
    Given user opens browser and navigates to "https://www.saucedemo.com/"
    When user enter username "<username>" and password "<password>"
    And  user clicks on login button
    Then error message should be displayed
    Examples:
    |username | password|
    |locked_out_user | secret_sauce|
    |standard_user   |secret       |
    |                |             |
    |standard_user   |             |


