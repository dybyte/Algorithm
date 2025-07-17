class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = grid[i-1][j-1];
            }
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){ 
                if(i==1 && j == 1) continue;
                int up = i == 1 ? Integer.MAX_VALUE : dp[i-1][j];
                int left = j == 1 ? Integer.MAX_VALUE : dp[i][j-1];
                dp[i][j] = Math.min(up, left) + dp[i][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }
}