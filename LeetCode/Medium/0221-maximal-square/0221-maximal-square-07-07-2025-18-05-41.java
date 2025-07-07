class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] arr = new int[matrix.length + 1][matrix[0].length + 1];
        int ans = 0;
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[0].length; j++){
                arr[i][j] = matrix[i-1][j-1] - '0';
            }
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[0].length; j++){
                if(arr[i][j] == 0) continue;
                arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])) + 1;
                ans = Math.max(ans, arr[i][j]);
            }
        }
        return ans * ans;
    }
}