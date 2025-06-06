class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] direction = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        for(int k = 0; k < direction.length; k++){
                            int nx = x + direction[k][0];
                            int ny = y + direction[k][1];
                            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == '1' && !visited[nx][ny]) {
                                queue.offer(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }
}