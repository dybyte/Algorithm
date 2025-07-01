class Solution {
    public void setZeroes(int[][] matrix) {
        Map<Integer, Boolean> row = new HashMap<>();
        Map<Integer, Boolean> col = new HashMap<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row.put(i,true);
                    col.put(j,true);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(row.getOrDefault(i, false)) matrix[i][j] = 0;
                else if(col.getOrDefault(j, false)) matrix[i][j] = 0;
            }
        }
    }
}