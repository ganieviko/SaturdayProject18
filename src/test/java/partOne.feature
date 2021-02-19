Feature: Adding a user and logging in by using the user

  Background:
    Given I navigate to website "http://thedemosite.co.uk/"

  Scenario Outline: User cannot be created with short credentials
    When I create username with "<username>" length less four characters and password "<password>" with  length less four characters
    Then I got an alert UserName message "Username too short.  The username must be at least 4 characters in length." or "Password too short.  The password must be at least 4 characters in length."
    Examples:
      | username | password |
      | asd      | Password |
      | UserName | asq      |
      | Use      | asq      |

  Scenario: User can be created with a username and a password whose lengths are more than 3 characters
    When I create username with user name and password whose lengths are more then tree characters using following parameters
      | username | Artur  |
      | password | Ganiev |
    Then I see my my username and password on screen

  Scenario: I can login using the credentials that have just been created
    When I create login using following parameters and save it
      | username | Artur  |
      | password | Ganiev |
    And go to login page and try login with parameters I just create
      | username | Artur  |
      | password | Ganiev |
    Then I see success message "**Successful Login**"

    Scenario Outline: User cannot login with invalid credentials
      When I create username with user name and password whose lengths are more then tree characters using following parameters
        | username | Artur  |
        | password | Ganiev |
      And go to login page and try login with different parameters such as "<username>" "<password>"
      Then I verify the alert "<message>" "<type>"
      Examples:
        | username | password  | message          |type
        | NotArtur | Ganiev    | **Failed Login** |message
        | Artur    | NotGaniev | **Failed Login** |message
        | NotArtur | NotGaniev | **Failed Login** |message



  Scenario Outline: User cannot login if at least one of the credentials is less than 4 characters
    When I create username with user name and password whose lengths are more then tree characters using following parameters
      | username | Artur  |
      | password | Ganiev |
    And go to the login page
    When I try to login with a invalid "<username>" and "<password>"
    Then  I verify the alert "<message>" "<type>"

    Examples:
      | username | password  | type    | message                                                                    |
      | NotArtur | Ganiev    | message | **Failed Login**                                                           |
      | Artur    | NotGaniev | message | **Failed Login**                                                           |
      | Not      | Not       | popUp   | Username too short.  The username must be at least 4 characters in length. |







