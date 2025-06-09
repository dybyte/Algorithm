class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> snakes = new HashMap<>();
        int count = 1;
        int flag = 0;
        for(int i = board.length - 1; i >= 0; i--){
            if(flag%2==0){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] != -1){
                        snakes.put(count,board[i][j]);
                    }
                    count++;
                } 
            } else{
                for(int j = board[0].length - 1; j >= 0; j--){
                    if(board[i][j] != -1){
                        snakes.put(count,board[i][j]);
                    }
                    count++;
                }
            }
            flag++;
        }
        boolean[] visited = new boolean[board.length*board.length + 1];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            if(poll[0] >= board.length * board.length) return poll[1];
            if(poll[1] > board.length * board.length) return -1;
            for(int i = 1; i <= 6; i++){
                int destination = poll[0] + i;
                destination = snakes.getOrDefault(destination, destination);
                if(destination < visited.length && !visited[destination]){
                    queue.offer(new int[]{destination,poll[1]+1});
                    visited[destination] = true;
                }
            }
        }
        return -1;
    }
}