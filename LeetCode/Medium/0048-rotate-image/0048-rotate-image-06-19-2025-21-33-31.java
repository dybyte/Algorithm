class Solution {
    public void rotate(int[][] matrix) {
        int[][] arr = new int[matrix.length][matrix.length];
        for(int k = 0; k < 3; k++){
            for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                arr[i][j] = matrix[i][j];
            }
        }

        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                matrix[arr.length - 1 - j][i] = arr[i][j];
            }
        }
        }
    }
}