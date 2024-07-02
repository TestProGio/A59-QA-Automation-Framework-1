Feature: Login feature
  # Hash is used to comment out areas in Selenium
  #1. Scenario Positive
  Scenario: Positive Login Scenario
    Given I open Koel Login Page
    When I enter email "giovanna.silva@testpro.io"
    And I enter password "ShakaMaya1302!"
    And I click submit
    Then I should be logged in

   #2. Scenario Negative
  Scenario Outline: Login Scenario
    Given I open Koel Login Page
    When I enter email "<Email>"
    And I enter password "<Password>"
    And I click submit
    Then I should be logged in
    Examples:
      | Email                     |Password        |
      | giovanna.s@testpro.io     | ShakaMaya1302! |
      | giovanna.silva@testpro.io | ShakaMaya13    |
      |                           | ShakaMaya1302! |
      | giovanna.silva@testpro.io |                |
      |                           |                |
      | gio.silva@testpro.io      | Shaka1302!     |



