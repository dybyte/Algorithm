class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], 2_000_000);
        }
        dp[0][0] = 0;
        for(int i = 0; i < triangle.size(); i++){
            List<Integer> arr = triangle.get(i);
            int size = arr.size();
            for(int j = 0; j < size; j++){
                dp[i+1][j+1] = Math.min(dp[i+1][j+1], Math.min(dp[i][j], dp[i][j+1]) + arr.get(j));
            }
        }
        int ans = Integer.MAX_VALUE;
        int lastIdx = triangle.size() - 1;
        for(int i = 1; i <= triangle.get(lastIdx).size(); i++){
            ans = Math.min(ans, dp[lastIdx+1][i]);
        }
        return ans;
    }
}