package learn.gomoku.game;

import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;
import learn.helpers.Input;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Menu {
    private static Scanner console;

    public static Scanner getConsole() {return console;}

    public Menu() {console = new Scanner(System.in);}

    public static void goodBye() {
        System.out.println("Goodbye!");
    }

    public static void printWelcome() {
        String welcome = "Welcome to Gomoku!";
        System.out.printf("%n%n%n%s%n%s%n%s%n%n", "=".repeat(welcome.length()),welcome, "=".repeat(welcome.length()));
    }

    public static void printWinner(Gomoku game) {
        String winMessage = game.getWinner() == null ? "%nIt's a draw!%n" : "%n%s WINS!!!%n";
        System.out.printf(winMessage, game.getWinner().getName());
    }

    public static boolean playAgain() {
        System.out.printf("%nPlay again? [1: yes, 2: no] ");
        return Input.getInt(getConsole(), 1, 2) == 1;
    }

    public void takeTurn(Gomoku game, Player currentPlayer) {
        System.out.printf("%n%s's turn", currentPlayer.getName());
        Stone stone = currentPlayer.generateMove(game.getStones());
        boolean human = stone == null;
        int row;
        int col;
        System.out.printf("%nEnter a row: ");
        System.out.printf("%s", 1 + (row = human? Input.getInt(console, 1, 15) - 1: stone.getRow()));
        System.out.printf("%nEnter a column: ");
        System.out.printf("%s", 1 + (col = human? Input.getInt(console, 1, 15) - 1: stone.getColumn()));
        stone = human? new Stone(row, col, game.isBlacksTurn()) : stone;
        Result result = game.place(stone);
        if(!result.isSuccess()){System.out.println(result);}
    }

    public void printBoard(Gomoku game) {
        String cellTemplate = "%3s";
        System.out.printf("%n%n%n");
        for (int r = 0; r < 16; r++) {
            for (int c = 0; c < 16; c++) {
                if(r == 0) {
                    System.out.printf(cellTemplate, c);
                } else if(c == 0) {
                    System.out.printf("%n%s", String.format(cellTemplate, r));
                } else {
                    char val = game.getCell(r-1, c-1);
                    System.out.printf(cellTemplate, val == 0 ? "_" : val);
                }
            }
        }
        System.out.println();
    }

    public Gomoku gameSetup() {
        Gomoku game = new Gomoku(selectPlayer(1), selectPlayer(2));
        System.out.printf("%nRandomizing...%n");
        System.out.printf("%n%s goes first.%n", game.getCurrent().getName());
        return game;
    }

    public Player selectPlayer(int playerNum) {
        System.out.printf("%n%nPlayer %s select:%n[1: Human, 2: Random]:%n", playerNum);
        int playerType = Input.getInt(console, 1, 2);
        Player player;
        if (playerType == 1) {
            System.out.printf("%nEnter player %s's name: ", playerNum);
            player = new HumanPlayer(Input.getWord(console));
            System.out.printf("%nPlayer %s's name is %s%n", playerNum, player.getName());
        } else {
            player = new RandomPlayer();
            System.out.printf("%nPlayer %s's name is %s%n", playerNum, player.getName());
        }
        return player;
    }

}
