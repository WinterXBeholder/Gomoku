package learn.gomoku.game;

import java.util.List;

public class Board {
    private char[][] board = new char[15][15];

    public Board(List<Stone> list) {
        char[][] newBoard = new char[15][15];
        for(Stone stone : list) {
            newBoard[stone.getRow()][stone.getColumn()] = stone.isBlack() ? 'x' : 'o';
        }
        board = newBoard;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }
}
