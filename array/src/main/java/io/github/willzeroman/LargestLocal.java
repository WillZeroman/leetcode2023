package io.github.willzeroman;

import java.util.Arrays;

public class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = getMax(grid, i, j);
                ans[i - 1][j - 1] = max;
            }
        }
        return ans;
    }

    private int getMax(int[][] grid, int i, int j) {
        int max = 0;
        for (int p = 0; p < 3; p++) {
            for (int k = 0; k < 3; k++) {
                max = Math.max(max, grid[p + i - 1][k + j - 1]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
        int[][] ans = new LargestLocal().largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8,
                2, 6, 4}, {6, 2, 2, 2}});
        Arrays.stream(ans).forEach(p -> System.out.println(Arrays.toString(p)));
        //[[20,8,20,6,16,16,7,16,8,10],[12,15,13,10,20,9,6,18,17,6],[12,4,10,13,20,11,15,5,17,1],
        // [7,10,14,14,16,5,1,7,3,11],[16,2,9,15,9,8,6,1,7,15],[18,15,18,8,12,17,19,7,7,8],[19,
        // 11,15,16,1,3,7,4,7,11],[11,6,5,14,12,18,3,20,14,6],[4,4,19,6,17,12,8,8,18,8],[19,15,
        // 14,11,11,13,12,6,16,19]]
        int[][] ans1 = new LargestLocal().largestLocal(new int[][]{{20, 8, 20, 6, 16, 16, 7, 16,
                8, 10}, {12, 15, 13, 10, 20, 9, 6, 18, 17, 6}, {12, 4, 10, 13, 20, 11, 15, 5, 17,
                1}, {7, 10, 14, 14, 16, 5, 1, 7, 3, 11}, {16, 2, 9, 15, 9, 8, 6, 1, 7, 15}, {18,
                15, 18, 8, 12, 17, 19, 7, 7, 8}, {19, 11, 15, 16, 1, 3, 7, 4, 7, 11}, {11, 6, 5,
                14, 12, 18, 3, 20, 14, 6}, {4, 4, 19, 6, 17, 12, 8, 8, 18, 8}, {19, 15, 14, 11, 11, 13, 12, 6, 16, 19}});
        Arrays.stream(ans1).forEach(p -> System.out.println(Arrays.toString(p)));
    }
}
