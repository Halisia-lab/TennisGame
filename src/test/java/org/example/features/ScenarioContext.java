package org.example.features;

import org.example.Game;
import org.example.Player;

public class ScenarioContext {
    public Game game = new Game(new Player("player1"), new Player("player2"));
}
