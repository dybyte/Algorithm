class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        boolean[] dp = new boolean[amount+1];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] > amount) continue;
            dp[coins[i]] = true;
            queue.offer(new int[]{coins[i],1});
        }
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            if(!dp[poll[0]]) dp[poll[0]] = true;
            if(poll[0]==dp.length-1) return poll[1];
   
            for(int i = 0; i < coins.length; i++){
                if(coins[i] > amount) continue;
                if((long)coins[i] + poll[0] >= (long)dp.length) continue;
                if(!dp[coins[i] + poll[0]]) dp[coins[i] + poll[0]] = true;
                else continue;
                queue.offer(new int[]{coins[i]+poll[0],poll[1]+1});
            }
        }
        return -1;
    }
}