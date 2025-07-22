class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[] column = new int[n];
        for(int i = 0; i < n; i++){
            column[0] = i;
            backTracking(column, 0, n);
        }
        return count;
    }

    void backTracking(int[] column, int row, int n){
        for(int i =  0; i < row; i++){
            if(column[row] == column[i] 
            || Math.abs(row - i) == Math.abs(column[row] - column[i])) return;
        }
        if(row == n-1) {
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
            column[row + 1] = i;
            backTracking(column, row + 1, n);
        }
    }
}