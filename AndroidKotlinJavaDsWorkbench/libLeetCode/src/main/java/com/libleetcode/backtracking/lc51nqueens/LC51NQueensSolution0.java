package com.libleetcode.backtracking.lc51nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51NQueensSolution0 implements LC51NQueensInterface {

    @Override
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, allBoards, 0);

        return allBoards;
    }

    private void helper(char[][] board, List<List<String>> allBoards, int col) {
        System.out.println("\n*** " + col + " *** \n" + Arrays.deepToString(board) + "\n *** \n");
        for (int row = 0; row < board.length; row++) {
            if (col == board.length) {
                saveBoard(board, allBoards);
                return;
            }

            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {
        //horizontal check
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'Q')
                return false;
        }

        //vertical check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        //upper left check
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') return false;
        }


        //upper right check
        r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') return false;
        }

        //lower left
        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') return false;
        }

        //lower right
        for (int c = col; c < board.length && r < board.length; r++, c++) {
            if (board[r][c] == 'Q') return false;
        }


        return true;
    }

    private void saveBoard(char[][] board, List<List<String>> allBoards) {
        StringBuilder row;

        List<String> newBoard = new ArrayList<>();

        for (char[] chars : board) {
            row = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == 'Q')
                    row.append('Q');
                else row.append('.');
            }
            newBoard.add(row.toString());
        }
        allBoards.add(newBoard);
    }

    /*private void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";

        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q')
                    row += 'Q';
                else row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }*/
}
