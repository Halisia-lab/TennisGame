@Game
Feature: Score translation
  Background: Game with 2 players
    Given game with playerOne and playerTwo

  Scenario: No points is LOVE
    Given playerOne has scored 0 times
    Then playerOne score translation should be "LOVE"

  Scenario: One point is FIFTEEN
    Given playerOne has scored 1 times
    Then playerOne score translation should be "FIFTEEN"

  Scenario: Two points is THIRTY
    Given playerOne has scored 2 times
    Then playerOne score translation should be "THIRTY"

  Scenario: Three points is FORTY
    Given playerOne has scored 3 times
    Then playerOne score translation should be "FORTY"

  Scenario: Four points can't be translated
    Given playerOne has scored 4 times
    Then playerOne score 4 should not be translated