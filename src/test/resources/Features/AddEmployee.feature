Feature: Adding a new employee in HRMS Application
  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    When user clicks on PIM option
    And user clicks on Add Employee button


  @smoke
  Scenario:Adding an employee
    When user enters firstname and lastname
    And user clicks on save button
    Then employee successfully added

    @sprint4
    Scenario: Adding employee from feature file
      When user enters "Fatima" and "Aou" and "Chak"
      And user clicks on save button
      Then employee successfully added
      @excel
      Scenario: adding employees from excel file
        When user adds multiple employees using excel from "EmployeeDataBatch16" and verify it
