class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                    continue;
                }

                if (row > 0) {
                    dp[row][col] += dp[row - 1][col];
                }

                if (col > 0) {
                    dp[row][col] += dp[row][col - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}