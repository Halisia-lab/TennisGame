package org.example.domain;

import org.assertj.core.api.Assertions;
import org.example.Game;
import org.example.Player;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GameTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldBeginWithScoresAt0()
    {
        Game tennisGame = new Game(new Player("playerOne"), new Player("playerTwo"));
        Assertions.assertThat(tennisGame.getPlayerOne().getScore()).isEqualTo(0);
        Assertions.assertThat(tennisGame.getPlayerTwo().getScore()).isEqualTo(0);
    }
}
