class Solution {
    public int findPeakElement(int[] nums) {
        int max = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(max < nums[i]) {
                ans = i;
                max = nums[i];
            }
        }
        return ans;
    }
}