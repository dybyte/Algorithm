class Solution {
    int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        //dfs
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                visited[i][j] = true;
                if(dfs(board, i, j, word, 0, visited)) return true;
                visited[i][j] = false;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int row, int col, String word, int idx, boolean[][] visited){
        if(board[row][col] != word.charAt(idx)) {
            return false;
        }
        if(idx == word.length() - 1) return true;

        boolean result = false;

        for(int[] direction : DIRECTIONS){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board[0].length && !visited[nextRow][nextCol]){
                visited[nextRow][nextCol] = true;
                result = dfs(board, nextRow, nextCol, word, idx+1, visited);
                visited[nextRow][nextCol] = false;
                if(result) return true;
            }
        }
        return false;
    }
}