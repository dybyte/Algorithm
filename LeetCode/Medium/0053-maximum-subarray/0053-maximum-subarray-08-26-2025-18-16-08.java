class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }

        int minIdx = -1;
        int maxIdx = -1;
        int ans = 0;
        for(int i = 0; i < sum.length; i++){
            int min = minIdx == -1 ? 0 : sum[minIdx];
            int max = maxIdx == -1 ? Integer.MIN_VALUE : sum[maxIdx];
            if(min > sum[i]){
                ans = Math.max(ans, max - min);
                minIdx = i;
                maxIdx = i;
            } 
            if(max < sum[i]){
                maxIdx = i;
            }
        }
        int min = minIdx == -1 ? 0 : sum[minIdx];
        int max = maxIdx == -1 ? 0 : sum[maxIdx];
        return Math.max(ans, max - min);
    }
}