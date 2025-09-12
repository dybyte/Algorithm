class Solution {
    int[][] DIRECTIONS = {
        {1,0},{-1,0},{0,1},{0,-1}
    };
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] notSurrounded = new boolean[m][n];
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') {
                notSurrounded[i][0] = true;
                dfs(board, notSurrounded, i, 0, m, n);
            }
            if(board[i][n-1] == 'O') {
                notSurrounded[i][n-1] = true;
                dfs(board, notSurrounded, i, n-1, m, n);
            }
        }
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') {
                notSurrounded[0][j] = true;
                dfs(board, notSurrounded, 0, j, m, n);
            }
            if(board[m-1][j] == 'O') {
                notSurrounded[m-1][j] = true;
                dfs(board, notSurrounded, m-1, j, m, n);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && !notSurrounded[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, boolean[][] notSurrounded, int i, int j, int m, int n){
        for(int k = 0; k < 4; k++){
            int nI = i + DIRECTIONS[k][0];
            int nJ = j + DIRECTIONS[k][1];
            if(nI < 0 || nI >= m || nJ < 0 || nJ >= n) continue;
            if(board[nI][nJ] == 'X' || notSurrounded[nI][nJ]) continue;
            notSurrounded[nI][nJ] = true;
            dfs(board, notSurrounded, nI, nJ, m, n);
        }
    }
}