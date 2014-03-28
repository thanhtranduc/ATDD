Feature: Login
  As a customer
  I want to login to the system
  So that I can see my personal information and my orders

  Scenario : login successfully
    When I input 'userName' as 'Tim'
    And  I input 'password' as '123456'
    And I decide to Login
    Then I should see display name and number of orders

  Scenario : login fail
    When I input 'userName' as 'Tim'
    And  I input 'password' as '12345678'
    And I decide to Login
    Then I should see the error message "userName or password is invalid"


