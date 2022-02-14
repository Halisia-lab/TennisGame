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
        Game game = new Game(tom, jerry);
        game.play();

    }
}
