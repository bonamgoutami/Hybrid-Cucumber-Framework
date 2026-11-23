Feature: Window Handle test
  Scenario: switch to Twitter window and get back to parent
    Given user opens browser and navigates to "https://www.saucedemo.com/"
    When user enter username "standard_user" and password "secret_sauce"
    And user clicks on Twitter link in footer
    Then user should switch to Twitter window  and verify title
    And user should close child window and come back to parent window