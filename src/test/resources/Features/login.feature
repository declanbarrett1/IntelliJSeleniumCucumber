Feature: Login Successfully
  @TestLoginWithNoExternalData
  Scenario: Login is Successful with no external data
    Given User Loads Up Browser
    When User navigates to login page
    And User inputs username
    And User inputs password
    And user clicks login button
    Then validate login success
    And browser teardown

    @TestLoginWithData
    Scenario Outline:Login is successful with data
      Given User Has Opened Browser
      When User has gone to OrangeHRM
      And User inputs username "<username>" and password "<password>"
      And User clicks to login
      Then Validate Login
      And Quit Browser
      Examples:
        |username  | password   |
        |Admin     | admin123   |
