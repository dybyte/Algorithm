class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]) {
                visited[i] = true;
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    void dfs(int[][] isConnected, boolean[] visited, int idx){
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[idx][i] == 0) continue;
            if(!visited[i]) {
                visited[i] = true;
                dfs(isConnected,visited,i);
            }
        }
    }
}