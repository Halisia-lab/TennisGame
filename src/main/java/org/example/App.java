package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Player tom = new Player("Tom");
        Player jerry = new Player("Jerry");
        tom.setScore(3);
        jerry.setScore(3);
        Game game = new Game(tom, jerry);
        game.play();

    }
}
//TODO deux joueurs differents, scores pas zero -> resume + verif si score possibles
//TODO si == 0 start
//TODO si != 0 est ce que legaux resume sinon exception