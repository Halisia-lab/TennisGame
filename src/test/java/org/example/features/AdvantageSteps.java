package org.example.features;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.example.Game;

public class AdvantageSteps {

    @Then("playerOne should have advantage in {game}")
    public void playerOneShouldHaveAnAdvantage(Game game) {
        Assertions.assertThat(game.getAdvantage()).isEqualTo(game.getPlayerOne());
    }

    @Then("playerTwo should have advantage in {game}")
    public void playerTwoShouldHaveAnAdvantage(Game game) {
        Assertions.assertThat(game.getAdvantage()).isEqualTo(game.getPlayerTwo());
    }

    @Then("nobody should have advantage in {game}")
    public void nobodyShouldHaveAdvantageInGame(Game game) {
        Assertions.assertThat(game.getAdvantage()).isNull();
    }


}
