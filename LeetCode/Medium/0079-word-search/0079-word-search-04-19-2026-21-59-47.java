class Solution {
    int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        //board에서 word가 있는지 찾는 문제
        //중복 사용은 불가능
        //대문자로만 구성
        /**
        dfs를 사용해서 word가 있는지 찾을 수 있음
         */
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = true;
                if(dfs(board, word, board[i][j], 0, visited, i, j, m, n)){
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, char current, int idx, boolean[][] visited, int row, int col, int m, int n) {
        if(idx == word.length()-1 && word.charAt(idx) == current) return true;
        if(word.charAt(idx) != current) return false;
    
        for(int[] direction : DIRECTIONS){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if(nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n){
                if(visited[nextRow][nextCol]) continue;
                visited[nextRow][nextCol] = true;
                if(dfs(board, word, board[nextRow][nextCol], idx+1, visited, nextRow, nextCol, m, n)){
                    return true;
                }
                visited[nextRow][nextCol] = false;
            }
        }

        return false;
    }
}