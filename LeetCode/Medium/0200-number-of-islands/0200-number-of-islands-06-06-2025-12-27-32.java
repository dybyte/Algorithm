class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] direction = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        for(int k = 0; k < 4; k++){
                            int nx = x + direction[k][0];
                            int ny = y + direction[k][1];
                            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == '1') {
                                queue.offer(new int[]{nx,ny});
                                grid[nx][ny] = '0';
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