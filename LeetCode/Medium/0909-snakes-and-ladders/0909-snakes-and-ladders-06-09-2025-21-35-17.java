class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> map = new HashMap<>();
        int flag = 0;
        int count = 1;
        for(int i = board.length - 1; i >= 0; i--){
            if(flag%2==0){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j]!=-1) map.put(count,board[i][j]);
                    count++;
                }
            } else {
                for(int j = board[0].length - 1; j >= 0; j--){
                    if(board[i][j]!=-1) map.put(count,board[i][j]);
                    count++;
                }
            }
            flag++;
        }
        int n = board.length * board.length;
        boolean[] visited = new boolean[n+1];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            if(poll[0] >= n) return poll[1];
            if(poll[1] >= n) return -1;
            for(int i = 1; i <= 6; i++){
                int destination = map.getOrDefault(poll[0] + i, poll[0] + i);
                if(destination < visited.length && !visited[destination]){
                    queue.offer(new int[]{destination,poll[1]+1});
                    visited[destination] = true;
                }
            }
        }
        return -1;
    }
}