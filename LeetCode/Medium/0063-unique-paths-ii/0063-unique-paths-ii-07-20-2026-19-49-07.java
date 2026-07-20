class Solution {
    int[][] DIRECTION = {{1,0}, {0,1}};
    int ans = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1) return 0;
        dfs(0,0,obstacleGrid,m,n,dp);
        return dp[0][0];
    }

    void dfs(int col, int row, int[][] obstacleGrid, int m, int n, int[][] dp) {
        if(col == m-1 && row == n-1) dp[col][row] = 1;

        for(int[] direction : DIRECTION) {
            int nextCol = col + direction[0];
            int nextRow = row + direction[1];
            if(nextCol < m && nextRow < n && obstacleGrid[nextCol][nextRow] == 0) {
                if(dp[nextCol][nextRow] == 0) {
                    
                    dfs(nextCol, nextRow, obstacleGrid, m, n, dp);
                   
                }
                dp[col][row] += dp[nextCol][nextRow];
            }
        }
    }
}