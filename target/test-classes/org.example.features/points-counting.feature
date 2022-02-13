@Game
  Feature: Points counting
    Background: Game with 2 players
      Given game with playerOne and playerTwo

    Scenario: First point of playerOne
      Given playerOne has scored 0 times
      And playerTwo has scored 0 times
      When playerOne scores
      Then playerOne's score should be 1

    Scenario: Second point of playerOne
      Given playerOne has scored 1 times
      And playerTwo has scored 0 times
      When playerOne scores
      Then playerOne's score should be 2

    Scenario: Third point of playerOne
      Given playerOne has scored 2 times
      And playerTwo has scored 0 times
      When playerOne scores
      Then playerOne's score should be 3

    Scenario: Fourth point of playerOne
      Given playerOne has scored 3 times
      And playerTwo has scored 0 times
      When playerOne scores
      Then playerOne's score should be 4
      And game winner should be playerOne

