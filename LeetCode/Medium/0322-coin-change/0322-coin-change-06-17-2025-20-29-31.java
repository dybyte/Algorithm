class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        for(int i = 1; i < dp.length; i++) dp[i] = -1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int poll = queue.poll();
            if(poll==dp.length-1) return dp[dp.length-1];
   
            for(int i = 0; i < coins.length; i++){
                if((long)coins[i] + poll >= dp.length) continue;
                int next = coins[i] + poll;
                if(dp[next] == -1) dp[next] = dp[poll] + 1;
                else continue;
                queue.offer(next);
            }
        }
        return -1;
    }
}