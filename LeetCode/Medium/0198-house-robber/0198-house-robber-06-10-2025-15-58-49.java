class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int num1 = i-2>=0 ? dp[i-2]+nums[i] : nums[i];
            int num2 = i-3>=0 ? dp[i-3]+nums[i] : nums[i];
            dp[i] = Math.max(num1,num2);
        }
        int num3 = nums.length-2>=0 ? dp[nums.length-2] : 0;
        return Math.max(dp[nums.length-1],num3);
    }
}