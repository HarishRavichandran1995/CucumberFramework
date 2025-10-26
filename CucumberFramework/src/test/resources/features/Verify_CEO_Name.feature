@GetCEOName
Feature: This feature is to get the job title for Employee from the OrangeHRM app

  Scenario Outline: This test is to verify job title for Employee
    Given the user is logged in successfully and is on Home Page
    When the user clicks on the directory option from the Menu bar
    And the user enters the employee name as "Test200 23 45" from the drop down
    And clicks the search button
    Then the user should see the job title for Emp as "<Emp_Name>"

  Examples:
  | Emp_Name          |
  | Software Engineer |
