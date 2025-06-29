class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        //bfs
        //grid2[i] == 1
        //!visited[i]
        //grid1[i] == 1
        int count = 0;
        boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < grid2.length; i++){
            for(int j = 0; j < grid2[0].length; j++){
                if(grid2[i][j] == 1 && !visited[i][j] && grid1[i][j] == 1) {
                    boolean isSub = true;
                    Queue<int[]> queue = new ArrayDeque<>();
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        for(int k = 0; k < 4; k++){
                            int nX = x + DIRECTIONS[k][0];
                            int nY = y + DIRECTIONS[k][1];
                            if(nX >= 0 && nX < grid2.length && nY >= 0 && nY < grid2[0].length){
                                if(grid2[nX][nY] == 1 && !visited[nX][nY]){
                                    if(grid1[nX][nY] == 1) {
                                        visited[nX][nY] = true;
                                        queue.offer(new int[]{nX,nY});
                                    } else {
                                        isSub = false;
                                    }
                                }
                            }
                        }
                    }
                    if(isSub)count++;
                }
            }
        }
        return count;
    }
}