class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){ 
                if(i == 0 && j == 0) continue;
                int up = i == 0 ? Integer.MAX_VALUE : grid[i-1][j];
                int left = j == 0 ? Integer.MAX_VALUE : grid[i][j-1];
                grid[i][j] = Math.min(up, left) + grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}