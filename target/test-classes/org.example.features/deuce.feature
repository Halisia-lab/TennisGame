@Game
Feature: Deuce

  Background: Game with 2 players
    Given game with playerOne and playerTwo


  Scenario: Players have 3 points
    Given playerOne has scored 3 times
    And playerTwo has scored 3 times
    Then game score should be DEUCE

  Scenario: Players are tied and have more than 3 points
    Given playerOne has scored 5 times
    And playerTwo has scored 5 times
    And game score should be DEUCE








  Scenario: Players have 3 points
    Given playerOne has scored 3 times
    And playerTwo has scored 2 times
    When playerTwo scores
    Then playerTwo's score should be 3
    Then game score should be DEUCE



