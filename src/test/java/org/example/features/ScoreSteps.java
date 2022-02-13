package org.example.features;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.example.Game;
import org.example.Player;

public class ScoreSteps {
    private ScenarioContext context;

    public ScoreSteps(ScenarioContext context) {
        this.context = context;
    }

    @ParameterType(".*")
    public Game game(String string) {
        return context.game;
    }

    @ParameterType(".*")
    public Player playerOne(String name) {
        return context.game.getPlayerOne();
    }

    @ParameterType(".*")
    public Player playerTwo(String name) {
        return context.game.getPlayerTwo();
    }

    @Given("{game} with {playerOne} and {playerTwo}")
    public void gameWithTwoPlayers(Game game, Player playerOne, Player playerTwo) {
        game.setPlayerOne(playerOne);
        game.setPlayerTwo(playerTwo);
    }

    @Given("playerOne has scored {int} times")
    public void playerOneHasPoints(int score) {
        context.game.getPlayerOne().setScore(score);
    }

    @Given("playerTwo has scored {int} times")
    public void playerTwoHasScoredTime(int score) {
        context.game.getPlayerTwo().setScore(score);
    }

    @When("playerOne scores")
    public void playerOneScores() {
        context.game.getPlayerOne().scores();
    }

    @When("playerTwo scores")
    public void playerTwoScores() {
        context.game.getPlayerTwo().scores();
    }

    @Then("playerOne's score should be {int}")
    public void playerOneScoreShouldBe(int score) {
        Assertions.assertThat(context.game.getPlayerOne().getScore()).isEqualTo(score);
    }

    @Then("playerTwo's score should be {int}")
    public void playerTwoScoreShouldBe(int score) {
        Assertions.assertThat(context.game.getPlayerTwo().getScore()).isEqualTo(score);
    }

    @Then("{game} winner should be playerOne")
    public void playerOneShouldBeTheWinner(Game game) {
        Assertions.assertThat(game.getWinner()).isEqualTo(game.getPlayerOne());
    }

    @Then("{game} winner should be playerTwo")
    public void playerTwoShouldBeTheWinner(Game game) {
        Assertions.assertThat(game.getWinner()).isEqualTo(game.getPlayerTwo());
    }

    @Then("{game} score should be DEUCE")
    public void gameScoreShouldBeDeuce(Game game) {
        Assertions.assertThat(game.isDeuce()).isTrue();
    }

    @Then("playerTwo should have advantage in {game}")
    public void playerTwoShouldHaveAnAdvantage(Game game) {
        Assertions.assertThat(game.getAdvantage()).isEqualTo(game.getPlayerTwo());
    }

    @Then("playerOne should have advantage in {game}")
    public void playerOneShouldHaveAnAdvantage(Game game) {
        Assertions.assertThat(game.getAdvantage()).isEqualTo(game.getPlayerOne());
    }

    @Then("playerOne score translation should be {string}")
    public void playerOneScoreTranslationShouldBe(String string) {
        Assertions.assertThat(context.game.getScoreTraduction().get(context.game.getPlayerOne().getScore())).isEqualTo(string);
    }


}
