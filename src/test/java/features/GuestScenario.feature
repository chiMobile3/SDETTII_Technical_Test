Feature: ecommerce mobile app place order as a guest feature

  Background:
    Given User clicks accept on login prompt
    Given User is on the Dashboard


  Scenario: User sorts the items
    When User chooses 'outdoor' category
    And User sorts by lower price
    Then User validate the price is sorted correctly

  Scenario: User validates category options
    When User picks Category
    And User clicks on Food and Grocery
    Then User enter en difference "options"
    Then User is on "options" page


  Scenario: User submits the form
    When User clicks on more
    And User chooses contact us
    Then User fills out the data
    And User submit the form

