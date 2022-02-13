package org.example;

import java.util.Map;

public class Game {
    private final Map<Integer, String> scoreNames = Map.of(
            3,"FORTY",
            2, "THIRTY",
            1, "FIFTEEN",
            0, "LOVE"
    );

    private Player playerOne;
    private Player playerTwo;


    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Map<Integer, String> getScoreTraduction() {
        return scoreNames;
    }

    public boolean isDeuce() {
        return this.playerOne.getScore() >= 3 && this.playerTwo.getScore() >= 3;
    }

    public Player playerWithHighestScore() {
        return playerOne.getScore() > playerTwo.getScore() ? playerOne : playerTwo;
    }

    public Player getWinner() {
        if(playerOne.getScore() >= 4 && playerOne.getScore() >= playerTwo.getScore() + 2) return playerOne;
        if(playerTwo.getScore() >= 4 && playerTwo.getScore() >= playerOne.getScore() + 2) return playerTwo;
        return null;
    }

    public Player getAdvantage() {
        if(playerOne.getScore() >= 4 && playerOne.getScore() >= playerTwo.getScore() + 1) return playerOne;
        if(playerTwo.getScore() >= 4 && playerTwo.getScore() >= playerOne.getScore() + 1) return playerTwo;
        return null;
    }

    public String translateScore(int score) {
        try {
            return scoreNames.get(score);
        } catch (Exception e) {
            throw new IllegalArgumentException("Illegal score: " + score);
        }
    }

    public String getScore() {

        /*if (hasWinner()) {
            return playerWithHighestScore() + " wins";
        }*/

        /*if (hasAdvantage()) {
            return "Advantage " + playerWithHighestScore();
        }*/

        if (isDeuce())
            return "Deuce";

        if(playerOne.getScore() == playerTwo.getScore()) {
            return translateScore(playerOne.getScore()) + " all";
        }

        return translateScore(playerOne.getScore()) + "," + translateScore(playerTwo.getScore());
    }

}
