package blind75;

import java.util.ArrayDeque;
import java.util.Queue;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        int M[][] = new int[][]
                { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println(getNumberOfIslands(M));
    }

    //row
    //col
    static int[] row = { -1, -1, -1,  0,  1, 0, 1, 1};
    static int[] col = { -1,  1,  0, -1, -1, 1, 0, 1};

    static int getNumberOfIslands(int[][] grid) {
        if (grid == null) return 0;

        int M = grid.length;
        int N = grid[0].length;

        boolean[][] processed = new boolean[M][N];

        int island = 0;
        for (int i = 0; i < M; i++) {

            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1 && !processed[i][j]) {
                    BFS(grid, processed, i, j);
                    island++;
                }
            }
        }
        return island;
    }

    static boolean isSafe(int[][] grid, int x, int y, boolean[][] processed) {
        return (x >= 0 && x < processed.length) && (y >= 0 && y < processed[0].length)
                && (grid[x][y] == 1 && !processed[x][y]);
    }

    static void BFS(int[][] grid, boolean[][] processed, int i, int j) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(i, j));

        processed[i][j] = true;

        while(!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();

            for (int k = 0; k < row.length; k++) {
                if (isSafe(grid, x + row[k], y + col[k], processed)) {
                    processed[x + row[k]] [y+col[k]] = true;
                    queue.add(new Pair(x + row[k], y + col[k]));
                }
            }
        }
    }

    static class Pair {
        int x, y;

        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
