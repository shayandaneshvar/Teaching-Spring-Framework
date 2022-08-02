# Created by User at 8/1/2022
Feature: person crud
  testing find and save method of person

  Scenario: user creates a new user
    When user saves the user
    Then user gets persisted