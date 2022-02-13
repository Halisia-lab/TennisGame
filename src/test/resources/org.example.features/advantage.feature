@Game
Feature: Advantage
  Rule: If at least three points have been scored by each side and a player has one more point than his opponent,
        the score of the game is “advantage” for the player in the lead
  Background: Game with 2 players
    Given game with playerOne and playerTwo

  Scenario: Players have scored 3 points each and one player takes advantage
    Given playerOne has scored 3 times
    And playerTwo has scored 3 times
    When playerTwo scores
    Then playerTwo's score should be 4
    And playerTwo should have advantage in game

  Scenario: Players have scored more than 3 points each and one player takes advantage
    Given playerOne has scored 5 times
    And playerTwo has scored 5 times
    When playerTwo scores
    Then playerTwo's score should be 6
    And playerTwo should have advantage in game

  Scenario: Players haven't scored 3 points each and one player takes the lead by one point
    Given playerOne has scored 1 times
    And playerTwo has scored 1 times
    When playerTwo scores
    Then playerTwo's score should be 2
    And nobody should have advantage in game



    
