@Game
Feature: Deuce
  Rule: At least three points have been scored by each player, and the scores are equal, the score is “deuce”
  Background: Game with 2 players
    Given game with playerOne and playerTwo

  Scenario: Both players have 3 points
    Given playerOne has scored 3 times
    And playerTwo has scored 3 times
    Then game score should be DEUCE

  Scenario: Players are tied and have more than 3 points
    Given playerOne has scored 5 times
    And playerTwo has scored 5 times
    Then game score should be DEUCE

  Scenario: A player looses the point in an ADVANTAGE
    Given playerOne has scored 3 times
    And playerTwo has scored 4 times
    When playerOne scores
    Then playerOne's score should be 4
    And game score should be DEUCE

  Scenario: Both players have 1 points
    Given playerOne has scored 1 times
    And playerTwo has scored 1 times
    Then game score should not be DEUCE








  Scenario: Players have 3 points
    Given playerOne has scored 3 times
    And playerTwo has scored 2 times
    When playerTwo scores
    Then playerTwo's score should be 3
    Then game score should be DEUCE



