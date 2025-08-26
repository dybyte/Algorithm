class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] prefix = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        int minPrefix = 0;
        int ans = Integer.MIN_VALUE;
        
        for (int i = 1; i <= nums.length; i++) {
            ans = Math.max(ans, prefix[i] - minPrefix);
            minPrefix = Math.min(minPrefix, prefix[i]);
        }
        return ans;
    }
}