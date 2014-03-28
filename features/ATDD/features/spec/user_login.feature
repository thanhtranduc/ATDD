@customer_order
Feature: Login
  As a customer
  I want to login to the system
  So that I can see my personal information and my orders

  Scenario: dummy

  Scenario: login successfully
    When I input 'username' as 'tim'
    And  I input 'password' as '123456'
    And I decide to Login
    Then I should see display name

  Scenario: Login fail
    When I input 'username' as 'tim'
    And  I input 'password' as '12345678'
    And I decide to Login
    Then I should see the error message "Username or password is invalid"


