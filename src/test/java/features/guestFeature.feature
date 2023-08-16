Feature: Sorting on outdoor items, validate category options, contact us submission form

    Background: User accept login prompt and on Dashboard

        Given User clicks accept on login prompt
        And User is on the Dashboard

    Scenario: User sorts the items

        When User chooses outdoor category
        And User sorts by lower price
        Then User validate the is sorted correctly


    Scenario Outline: User validates category options

        When User picks Category
        And User clicks on Home and Grocery
        Then User enter en difference "<options>"
        Then User is on "<options>" page

        Examples:
        |options|
        |Meat & Fish|
        |Fruits & Vegetables|
        |Groceries|

     Scenario: User submits the form

     When User clicks on "More"
     And User chooses "Contact us"
     Then User fills out the data
     And User submit the form