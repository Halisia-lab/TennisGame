@Game
Feature: Score translation
  Background: Game with 2 players
    Given game with playerOne and playerTwo


  Scenario: PlayerOne's fourth point and victory
    Given playerOne has scored 3 times
    And playerTwo has scored 0 times
    When playerOne scores
    Then playerOne's score should be 4
    And game winner should be playerOne

  Scenario: A player has ADVANTAGE and wins the point
    Given playerOne has scored 3 times
    And playerTwo has scored 4 times
    When playerTwo scores
    Then playerTwo's score should be 5
    And game winner should be playerTwo

  Scenario: PlayerOne scores fourth point but does not win
    Given playerOne has scored 3 times
    And playerTwo has scored 4 times
    When playerOne scores
    Then playerOne's score should be 4
    And game should not have a winner

  #Scenario: PlayerOne's fourth point and victory
    #Given playerOne has scored 4 times
    #And playerTwo has scored 2 times
    #When playerOne scores
    #Then playerOne's score should not be 3
    #And game winner should be playerOne

