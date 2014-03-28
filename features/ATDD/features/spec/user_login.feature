Feature: Add  order
  In order to add new order
  As a customer
  I want to login to the system
  So that I can see my personal information and my orders

  Scenario : login successfully
    When I input 'user_name' as 'Tim'
    And  I input 'password' as '123456'
    And I decide to Login
    Then I can see my personal information and my orders

  Scenario : login fail
    When I input 'user_name' as 'Tim'
    And  I input 'password' as '12345678'
    And I decide to Login
    Then I should see the error message "user name or password is invalid"


