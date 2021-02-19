Feature: Login Functionality tests for Campus website

  Background:
    Given I navigate to Mersys WebSite "https://test.campus.techno.study/"


    Scenario: I can login with valid credentials
      When I login with valid password "daulet2030@gmail.com" and login "TechnoStudy123@"
      And Click on login button
      Then I successfully login in Mersys Website

Scenario Outline: User cannot login with invalid credentials
  When I try to login with invalid login "<username>" or password "<password>"
  And Click on login button
  Then I got an error message "Invalid username or password"

  Examples:
    | username             | password        |
    | daulet2030           | TechnoStudy123@ |
    | daulet2030@gmail.com | TechnoGaniev    |
    | daulet2030           | TechnoGaniev    |
