class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] memo = new Integer[n][n][n];

        return Math.max(0, dfs(grid, 0, 0, 0, memo));
    }

    private int dfs(int[][] grid, int r1, int c1, int r2, Integer[][][] memo) {
        int n = grid.length;
        int c2 = r1 + c1 - r2; // because r1 + c1 == r2 + c2 at any point

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || 
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1]; // only one robot needs to reach the end
        }

        if (memo[r1][c1][r2] != null) {
            return memo[r1][c1][r2];
        }

        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int temp = Math.max(
            Math.max(dfs(grid, r1 + 1, c1, r2 + 1, memo), dfs(grid, r1 + 1, c1, r2, memo)),
            Math.max(dfs(grid, r1, c1 + 1, r2 + 1, memo), dfs(grid, r1, c1 + 1, r2, memo))
        );

        cherries += temp;

        memo[r1][c1][r2] = cherries;
        return cherries;
    }
}
