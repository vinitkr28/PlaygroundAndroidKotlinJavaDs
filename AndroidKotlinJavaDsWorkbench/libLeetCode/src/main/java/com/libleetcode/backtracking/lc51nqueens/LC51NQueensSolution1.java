package com.libleetcode.backtracking.lc51nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC51NQueensSolution1 implements LC51NQueensInterface {


    List<List<String>> res = new ArrayList<>();
    int[] columns;
    Map<Integer, String> map = new HashMap<>();

    @Override
    public List<List<String>> solveNQueens(int n) {
        columns = new int[n];
        char[] c = new char[n];
        Arrays.fill(c, '.');
        for (int i = 0; i < n; i++) {
            c[i] = 'Q';
            map.put(i, new String(c));
            c[i] = '.';
        }
        dfs(n, 0, 0, 0, 0);
        return res;
    }

    private void dfs(int n, int row, int col1, int di1, int di2) {
        if (row == n) {
            List<String> t = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                t.add(map.get(columns[i]));
            }
            res.add(t);
            return;
        }
        int availablePositions = ((1 << n) - 1) & (~(col1 | di1 | di2));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            int col = Integer.bitCount(position - 1);
            columns[row] = col;
            dfs(n, row + 1, col1 | position, (di1 | position) << 1, (di2 | position) >> 1);
        }
    }

    public static void main(String[] args) {
        LC51NQueensSolution1 solution = new LC51NQueensSolution1();
        List<List<String>> result = solution.solveNQueens(4);
        System.out.println(result);
        /*for (List<String> solutionBoard : result) {
            for (String row : solutionBoard) {
                System.out.println(row);
            }
            System.out.println();
        }*/
    }
}
