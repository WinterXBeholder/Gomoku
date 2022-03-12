package learn.gomoku.game;

import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.RandomPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private final HumanPlayer one = new HumanPlayer("Dori");
    private final HumanPlayer two = new HumanPlayer("Nemo");
    private Gomoku game;
    private Menu menu;

    @BeforeEach
    void setupBeforeEachTest() {
        // Create a new game before each test is ran.
        game = new Gomoku(one, two);
        menu = new Menu();
    }

    @Test
    void getConsole() {
        assertTrue(menu.getConsole() instanceof Scanner);
    }

    @Test
    void goodBye() {
        menu.goodBye();
    }

    @Test
    void printWelcome() {
        menu.printWelcome();
    }

    @Test
    void printWinner() {
        menu.printWinner(game);
    }

    @Test
    void playAgain() {
        System.out.println("type 1");
        boolean test = menu.playAgain();
        assertTrue(test);
        System.out.println("type 2");
        test = menu.playAgain();
        assertFalse(test);
    }

    @Test
    void takeTurn() {
        menu.takeTurn(game, game.getCurrent());
    }

    @Test
    void printBoard() {
        menu.printBoard(game);
    }

    @Test
    void gameSetup() {
        assertTrue(menu.gameSetup() instanceof Gomoku);
    }

    @Test
    void selectPlayer() {
        assertTrue(menu.selectPlayer(1) instanceof HumanPlayer);
        assertTrue(menu.selectPlayer(2) instanceof RandomPlayer);

    }
}