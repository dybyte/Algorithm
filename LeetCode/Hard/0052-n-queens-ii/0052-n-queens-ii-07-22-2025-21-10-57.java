class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[] column = new int[n];
        backTracking(column, 0, n);
        return count;
    }

    void backTracking(int[] column, int row, int n){
        if(row == n){
            count++;
            return;
        }
        Loop1 : for(int i = 0; i < n; i++){
            column[row] = i;
            //행은 안겹침
            //1. 열이 겹치는 확인
            //2. 대각선에 있는지 확인
            for(int j = 0; j < row; j++){
                if(column[j] == column[row]
                || Math.abs(j - row) == Math.abs(column[j] - column[row])){
                    continue Loop1;
                }
            }
            backTracking(column, row + 1, n);
        }
    }
}