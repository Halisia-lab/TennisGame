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
            return "** "+ getWinner().getName() + " WINS **";
        }

        if (getAdvantage() != null) {
            return String.format("ADVANTAGE : %s", getAdvantage().getName());
        }

        if(playerOne.getScore() == playerTwo.getScore()) {
            if (isDeuce()) {
                return "DEUCE";
            }
            return translateScore(playerOne.getScore()) + " all";
        }

        return String.format("%s : %s, %s : %s",
                playerOne.getName(), translateScore(playerOne.getScore()),playerTwo.getName(),translateScore(playerTwo.getScore()));
    }

    public boolean areScoresSuitable(int score1, int score2) {

        //if scores aren't suitable (ex 9 - 0)
        if(score1 >= 4 && score1 > score2 + 2 || score2 >= 4 && score2 > score1 + 2) {
            return false;
        }

        //if scores are suitable but someone won (ex 7 - 5)
        if(score1 >= 4 && score1 == score2 + 2) {
            System.out.println(playerOne.getName() + " already won");
            return false;
        }
        if(score2 >= 4 && score2 == score1 + 2) {
            System.out.println(playerTwo.getName() + " already won");
            return false;
        }

        return true;
    }

    public void play(){
        //Different players verification
        if(this.playerOne.equals(this.playerTwo)) {
            throw new IllegalArgumentException("Two different players are required");
        }

        //Suitable scores verification
        if(areScoresSuitable(playerOne.getScore(), playerTwo.getScore())) {

            if (this.playerOne.getScore() == 0 && this.playerTwo.getScore() == 0) {
                System.out.println("Game starts");
                System.out.println("------------------");
            } else {
                System.out.println("Game resumes");
                System.out.println("------------------");

            }

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
        } else {
            throw new IllegalArgumentException("Game can't start : illegal scores");
        }
    }
}
