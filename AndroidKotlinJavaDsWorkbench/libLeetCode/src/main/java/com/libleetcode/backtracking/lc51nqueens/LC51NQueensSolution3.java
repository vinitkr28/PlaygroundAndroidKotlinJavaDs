package com.libleetcode.backtracking.lc51nqueens;

import java.util.ArrayList;
import java.util.List;

public class LC51NQueensSolution3 implements LC51NQueensInterface {
    List<List<String>> ans = new ArrayList<>();  // List to store all the valid boards

    @Override
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];  // Create an n x n board

        // Initialize the board with dots ('.') indicating empty positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nQueens(board, 0);  // Start solving from the first row
        return ans;  // Return the list of all valid board configurations
    }

    // Check if it's safe to place a queen at board[row][col]
    public boolean isSafe(char[][] board, int row, int col) {
        // Check vertically upwards
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the diagonal left upwards
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the diagonal right upwards
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;  // It's safe to place a queen at board[row][col]
    }

    // Recursive function to place queens on the board
    public void nQueens(char[][] board, int row) {
        // Base case: if all queens are placed
        if (row == board.length) {
            addBoardToResult(board);  // Add the current board configuration to the result list
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';  // Place a queen
                nQueens(board, row + 1);  // Recur to place the rest of the queens
                board[row][col] = '.';  // Backtrack: remove the queen
            }
        }
    }

    // Convert the board to a list of strings and add to the result
    public void addBoardToResult(char[][] board) {
        List<String> boardConfig = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            boardConfig.add(new String(board[i]));  // Convert each row to a string
        }
        ans.add(boardConfig);  // Add the board configuration to the result list
    }

}