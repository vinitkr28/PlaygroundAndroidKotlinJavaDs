package com.libleetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC994RottingOranges {

    public int orangesRotting(int[][] grid) {
        //by bfs
        Queue<int[]> q = new LinkedList<>();

        int time = 0, rotten = 0, total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) total++;
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        if (total == 0) return 0;

        while (!q.isEmpty()) {
            int size = q.size();

            rotten += size;

            if (rotten == total) return time;

            time++;

            for (int i = 0; i < size; i++) {
                int[] p = q.peek();

                if (p == null) return -1;

                //right
                if (p[0] + 1 < grid.length && grid[p[0] + 1][p[1]] == 1) {
                    grid[p[0] + 1][p[1]] = 2;
                    q.offer(new int[]{p[0] + 1, p[1]});
                }

                //left
                if (p[0] - 1 >= 0 && grid[p[0] - 1][p[1]] == 1) {
                    grid[p[0] - 1][p[1]] = 2;
                    q.offer(new int[]{p[0] - 1, p[1]});
                }

                //up
                if (p[1] - 1 >= 0 && grid[p[0]][p[1] - 1] == 1) {
                    grid[p[0]][p[1] - 1] = 2;
                    q.offer(new int[]{p[0], p[1] - 1});
                }

                //bottom
                if (p[1] + 1 < grid[0].length && grid[p[0]][p[1] + 1] == 1) {
                    grid[p[0]][p[1] + 1] = 2;
                    q.offer(new int[]{p[0], p[1] + 1});
                }

                q.poll();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LC994RottingOranges rottingOranges = new LC994RottingOranges();

        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};

        int output = rottingOranges.orangesRotting(grid);
        System.out.println("Rotten time: \t" + output);
    }
}
