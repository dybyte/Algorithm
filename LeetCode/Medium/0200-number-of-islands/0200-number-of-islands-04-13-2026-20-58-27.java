class Solution {
    int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        /**
        0이 물, 1이 땅
        섬인지 판단하려면 0으로 둘러싸여있는지 확인.
        bfs
        0을 마주하는 경우, 탐색을 멈춥니다.
        한번의 bfs를 시도할때마다 하나의 섬을 찾을 수 있습니다.

        주의할점: 이미 방문했던 섬인지 확인해야합니다.
        visited[][]
         */
        int answer = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
         for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(visited, grid, i, j);
                    answer++;
                }
            }
         }

        return answer;
    }

    public void bfs(boolean[][] visited, char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int row = arr[0];
            int col = arr[1];
            for(int[] direction : DIRECTIONS){
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if(nextRow >= 0 && nextCol >=0 && nextRow < m && nextCol < n){
                    if(!visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1'){
                        queue.offer(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            
        }
    }
}