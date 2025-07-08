class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= nums[i]; j++){
                int tmp = i+j;
                if(tmp < nums.length){
                    dp[tmp] = Math.min(dp[tmp], dp[i] + 1);
                }
            }
        }
        return dp[nums.length-1];
    }
}