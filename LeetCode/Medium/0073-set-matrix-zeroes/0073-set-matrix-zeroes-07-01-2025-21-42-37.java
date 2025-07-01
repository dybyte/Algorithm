class Solution {
    public void setZeroes(int[][] matrix) {
        //O(1) 공간복잡도
        boolean colZero = false, rowZero = false;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) colZero = true;
        }

        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) rowZero = true;
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if(colZero) matrix[i][0] = 0;
        }

        for(int i = 0; i < matrix[0].length; i++) {
            if(rowZero) matrix[0][i] = 0;
        }
    }
}