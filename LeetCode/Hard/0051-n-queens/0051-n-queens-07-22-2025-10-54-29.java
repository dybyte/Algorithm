class Solution {
    StringBuilder sb = new StringBuilder("");
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] column = new int[n];
        backTracking(column, 0,n);
        return ans;
    }

    void backTracking(int[] column, int row, int n){
        if(row == n) {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(column[i] == j) sb.append("Q");
                    else sb.append(".");
                }
                list.add(sb.toString());
                sb.delete(0,n);
            }
            ans.add(list);
            return;
        }
        
        Loop1 : for(int i = 0; i < n; i++){
            column[row] = i;
            for(int j =  0; j < row; j++){
                if(column[row] == column[j] 
                || Math.abs(row - j) == Math.abs(column[row] - column[j])) continue Loop1;
            }
            backTracking(column, row + 1, n);
        }
    }
}