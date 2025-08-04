class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] indegree = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    int nI = i + DIRECTIONS[k][0];
                    int nJ = j + DIRECTIONS[k][1];
                    if(nI >= 0 && nJ >= 0 && nI < m && nJ < n
                    && matrix[nI][nJ] < matrix[i][j]){
                        indegree[i][j]++;
                    }
                }
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(indegree[i][j] == 0) queue.offer(new int[]{i,j});
            }
        }
        
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] poll = queue.poll();
                for(int k = 0; k < 4; k++){
                    int nI = poll[0] + DIRECTIONS[k][0];
                    int nJ = poll[1] + DIRECTIONS[k][1];
                    if(nI >= 0 && nJ >= 0 && nI < m && nJ < n
                    && matrix[nI][nJ] > matrix[poll[0]][poll[1]]){
                        indegree[nI][nJ]--;
                        if(indegree[nI][nJ] == 0) queue.offer(new int[]{nI, nJ});
                    }
                }
            }
        }
        return level;
    }
}