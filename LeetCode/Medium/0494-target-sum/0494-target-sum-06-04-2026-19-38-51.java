class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        
        return dfs(nums, 0, 0, target, memo);
    }

    private int dfs(int[] nums, int idx, int sum, int target, Map<String, Integer> memo) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = idx + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int plus = dfs(nums, idx + 1, sum + nums[idx], target, memo);
        int minus = dfs(nums, idx + 1, sum - nums[idx], target, memo);

        memo.put(key, plus + minus);

        return plus + minus;
    }
}