class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            cur = Math.max(nums[i], cur + nums[i]);
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}