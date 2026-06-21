class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        for(int i = 3; i < n - 1; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
        }

        int[] reverseDp = new int[n];

        reverseDp[n-1] = nums[n-1];
        reverseDp[n-2] = nums[n-2];
        reverseDp[n-3] = nums[n-1] + nums[n-3];

        for(int i = n - 4; i > 0; i--){
            reverseDp[i] = Math.max(reverseDp[i+2], reverseDp[i+3]) + nums[i];
        }
        
        return Math.max(Math.max(dp[n-3], dp[n-2]), Math.max(reverseDp[1], reverseDp[2]));
    }
}