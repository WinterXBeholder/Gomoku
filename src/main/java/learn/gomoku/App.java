package learn.gomoku;

import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.helpers.Input;
import learn.gomoku.players.Player;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.RandomPlayer;
import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Menu;

import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.printWelcome();

        boolean playAgain = true;
        do {
            Gomoku game = menu.gameSetup();

            Player currentPlayer;
            while (!game.isOver()) {
                currentPlayer = game.getCurrent();
                menu.printBoard(game);
                menu.takeTurn(game, currentPlayer);
            }

            menu.printBoard(game);
            menu.printWinner(game);
            playAgain = menu.playAgain();
        } while (playAgain);
        menu.goodBye();
    }


}
