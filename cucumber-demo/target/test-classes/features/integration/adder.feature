# Created by User at 5/24/2022
Feature: adder
  # adds two numbers

  Scenario Outline: adder
    Given I have the following inputs <a> and <b>
    Then I give them to the adder and expect <c>


    Examples:
      | a  | b | c |
      | 1  | 0 | 1 |
      | 0  | 2 | 2 |
      | 1  | 2 | 3 |
      | -1 | 1 | 0 |

