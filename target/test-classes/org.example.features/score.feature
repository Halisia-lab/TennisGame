@Game
Feature: Score naming
  Background: Game with 2 players
    Given game with playerOne and playerTwo

  Scenario: First point is LOVE
    Given playerOne has scored 0 times
    When playerTwo scores
    Then game score should be DEUCE

  Scenario: Both have more than 3 points and scores are equals
    Given playerOne has scored 5 times
    Given playerTwo has scored 4 times
    When playerTwo scores
    Then game score should be DEUCE

