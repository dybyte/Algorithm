class Solution {
    int[][] DIRECTION = {{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 1;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dp[i][j] = dfs(matrix, i, j, dp);
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    int dfs(int[][] matrix, int x, int y, int[][] dp){
        if(dp[x][y]!=0) return dp[x][y];

        int maxLen = 1;
        for(int i = 0; i < 4; i++){
            int nX = x + DIRECTION[i][0];
            int nY = y + DIRECTION[i][1];
            if(nX >= 0 && nY >= 0 && nX < matrix.length && nY < matrix[0].length
            && matrix[nX][nY] > matrix[x][y]){
                int len = 1 + dfs(matrix, nX, nY, dp);
                maxLen = Math.max(maxLen, len);
            }
        }
        dp[x][y] = maxLen;
        return maxLen;
    }
}