class Solution {
    int ans = 0;
    int max = 0;
    int min = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            max += nums[i];
        }
        min = -max;
        dfs(0,nums,target,-1);
        return ans;
    }

    void dfs(int sum, int[] nums, int target, int idx){
        int top = max + sum;
        int bottom = min + sum;
        if(top < target || min > target) return;

        if(idx + 1 == nums.length){
            if(sum == target){
                ans++;
            }
            return;
        }
        

        if(idx + 1 < nums.length){
            dfs(sum + nums[idx + 1], nums, target, idx + 1);
            dfs(sum - nums[idx + 1], nums, target, idx + 1);
        }
    }
}