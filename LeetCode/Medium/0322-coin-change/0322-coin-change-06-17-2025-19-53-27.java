class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < coins.length; i++) {
             if(coins[i] > amount) continue;
            queue.offer(new int[]{coins[i],1});
        }
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            if(poll[0]==amount) return poll[1];
            if(poll[0]>amount) continue;
   
            for(int i = 0; i < coins.length; i++){
                if(coins[i] > amount) continue;
                if(poll[0] + coins[i] >= dp.length || dp[poll[0]+coins[i]] >= poll[1]+1) continue;
                dp[poll[0]+coins[i]] = poll[1] + 1;
                queue.offer(new int[]{coins[i]+poll[0],poll[1]+1});
            }
        }
        return -1;
    }
}