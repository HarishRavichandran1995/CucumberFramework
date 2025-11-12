@GetCEOName
Feature: This feature is to get the job title for Employee from the OrangeHRM app

  Scenario Outline: This test is to verify job title for Employee
    Given the user is logged in successfully and is on Home Page
    When the user clicks on the directory option from the Menu bar
    And the user selects job title as "Chief Financial Officer" from the drop down
    And clicks the search button
    Then the user should see the emp name as "<Emp_Name>"

  Examples:
  | Emp_Name          |
  | Peter Mac Anderson  |
