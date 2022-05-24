# Created by User at 5/24/2022
Feature: reverser
  # reverser should reverse ..
  # NOTE: how field to full object mapping is being done
  Scenario: when is not empty
    Given I have the following users
      | name   | someText |
      | ali    | jinx     |
      | shayan | gtx      |
      | adel   | where    |
      | ehsan  | some     |
    When I reverse their text
    Then I want their reversed to be equal the following
      | xnij  |
      | xtg   |
      | erehw |
      | emos  |
