class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //O(n^2)
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], 2_000_000);
        }
        dp[0][0] = 0;
        for(int i = 0; i < n; i++){
            List<Integer> arr = triangle.get(i);
            for(int j = 0; j < arr.size(); j++){
                dp[i+1][j+1] = Math.min(dp[i][j], dp[i][j+1]) + arr.get(j);
            }
        }

        int ans = Integer.MAX_VALUE;
        List<Integer> last = triangle.get(n-1);
        for(int i = 1; i <= last.size(); i++){
            ans = Math.min(ans,dp[n][i]);
        }
        return ans;
    }
}