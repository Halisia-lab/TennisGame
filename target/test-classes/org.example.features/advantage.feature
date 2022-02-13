@Game
Feature: Advantage
  Background: Game with 2 players
    Given game with playerOne and playerTwo

  Scenario: A player wins a point in a DEUCE
    Given playerOne has scored 3 times
    And playerTwo has scored 3 times
    When playerTwo scores
    And playerTwo's score should be 4
    And game advantage should be playerTwo

  Scenario: A player wins a point in an ADVANTAGE
    Given playerOne has scored 3 times
    And playerTwo has scored 4 times
    When playerTwo scores
    And playerTwo's score should be 5
    And game winner should be playerTwo
    
