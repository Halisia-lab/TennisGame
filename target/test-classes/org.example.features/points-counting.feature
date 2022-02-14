@Game
  Feature: Points counting
    Background: Game with 2 players
      Given game with playerOne and playerTwo

    Scenario: PlayerOne's first point
      Given playerOne has scored 0 times
      And playerTwo has scored 0 times
      When playerOne scores
      Then playerOne's score should be 1

    Scenario: PlayerOne's second point
      Given playerOne has scored 1 times
      And playerTwo has scored 0 times
      When playerOne scores
      Then playerOne's score should be 2

    Scenario: PlayerOne's third point
      Given playerOne has scored 2 times
      And playerTwo has scored 0 times
      When playerOne scores
      Then playerOne's score should be 3

