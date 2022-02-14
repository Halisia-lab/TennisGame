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
        return this.playerOne.getScore() >= 3 && this.playerOne.getScore() == this.playerTwo.getScore();
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

    public String getGameScore() {

        if (getWinner() != null) {
            return getWinner().getName() + " WINS";
        }

        if (getAdvantage() != null) {
            return String.format("ADVANTAGE : %s", getAdvantage().getName());
        }

        if(playerOne.getScore() == playerTwo.getScore()) {
            if (isDeuce()) {
                return "DEUCE";
            }
            return translateScore(playerOne.getScore()) + " ALL";
        }

        return String.format("%s : %s, %s : %s",
                playerOne.getName(), translateScore(playerOne.getScore()),playerTwo.getName(),translateScore(playerTwo.getScore()));
    }

    public void play(){

        System.out.println("game starts");
        System.out.println(getGameScore());
        //TODO voir avec les filles pour un illegalScoreException (si on entre des players avec p1.score = 8 et p2.score = 3 par exemple)
        // => pas expliqué par codé ?
        while(getWinner() == null){
            if((int)Math.round(Math.random()) == 0){
                playerOne.scores();
                System.out.println(playerOne.getName() + " scores");
            } else{
                playerTwo.scores();
                System.out.println(playerTwo.getName() + " scores");
            }
            System.out.println(getGameScore());
        }
    }

}
