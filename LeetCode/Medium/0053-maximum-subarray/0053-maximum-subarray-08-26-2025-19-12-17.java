class Solution {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
        }

        int min = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < sum.length; i++){
            ans = Math.max(ans, sum[i] - min);
            min = Math.min(min, sum[i]);
        }

        return ans;
    }
}