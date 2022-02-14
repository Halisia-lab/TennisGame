package org.example.features;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.example.Game;
import org.example.Player;

public class DeuceSteps {

    @Then("{game} score should be DEUCE")
    public void gameScoreShouldBeDeuce(Game game) {
        Assertions.assertThat(game.isDeuce()).isTrue();
    }

    @Then("{game} score should not be DEUCE")
    public void gameScoreShouldNotBeDEUCE(Game game) { Assertions.assertThat(game.isDeuce()).isFalse();
    }
}
