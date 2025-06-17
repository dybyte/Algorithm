class Solution {
    public int coinChange(int[] coins, int amount) {
        //bfs
        int[] visited = new int[amount+1];   //최소 동전의 개수
        Queue<Integer> queue = new ArrayDeque<>(); //현재 총합

        Arrays.fill(visited, -1);

        queue.offer(0);
        visited[0] = 0;

        while(!queue.isEmpty()){
            int poll = queue.poll();
            if(poll == amount) return visited[poll];
            for(int coin : coins){
                long next = (long)poll + coin;
                if(next > amount) continue;
                if(visited[(int)next] == -1) {
                    visited[(int)next] = visited[poll] + 1; 
                    queue.offer((int)next);
                }
            }
        }

        return -1;
    }
}