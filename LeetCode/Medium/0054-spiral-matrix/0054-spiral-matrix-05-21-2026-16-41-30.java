class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int row = 0;
        int col = 0;
        List<Integer> answer = new ArrayList<>();
        answer.add(matrix[0][0]);
        visited[0][0] = true;

        while(true){
            if(answer.size() == m*n) return answer;

            for(int i = col + 1; i < n; i++){
                if(!visited[row][i]) {
                    visited[row][i] = true;
                    col = i;
                    answer.add(matrix[row][i]);
                }
                else break;
            }

            for(int i = row + 1; i < m; i++){
                if(!visited[i][col]) {
                    visited[i][col] = true;
                    row = i;
                    answer.add(matrix[i][col]);
                }
                else break;
            }

            for(int i = col - 1; i >= 0; i--){
                if(!visited[row][i]) {
                    visited[row][i] = true;
                    col = i;
                    answer.add(matrix[row][i]);
                }
                else break;
            }

            for(int i = row - 1; i >= 0; i--){
                if(!visited[i][col]) {
                    visited[i][col] = true;
                    row = i;
                    answer.add(matrix[i][col]);
                }
                else break;
            }
        }
        
    }
}