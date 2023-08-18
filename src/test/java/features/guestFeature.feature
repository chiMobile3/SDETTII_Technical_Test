Feature: Sorting on outdoor items, validate category options, contact us submission form

  Background: User accept login prompt and on Dashboard

    Given User clicks accept on login prompt
    And User is on the Dashboard

  Scenario: User sorts the items

    When User chooses "Outdoor" category
    And User sorts by "Price: Low to High"
    Then User validate the value is sorted correctly


  Scenario Outline: User validates category options

    When User clicks on "Category"
    And User clicks on Food & Grocery
    Then User enters different options from "<excelSheet>" and "<OptionIndex>"
    Then User validates the displayed page content with "<excelSheet>" and "<OptionIndex>"

    Examples:
      | excelSheet  | OptionIndex |
      | OptionsList | 0           |
      | OptionsList | 1           |
      | OptionsList | 2           |

  Scenario: User submits the form

    When User clicks on "More"
    And User chooses "Contact us"
    Then User fills out the data
    And User submit the form