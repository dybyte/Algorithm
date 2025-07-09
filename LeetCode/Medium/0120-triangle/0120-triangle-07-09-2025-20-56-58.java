class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[triangle.size()];
        List<Integer> last = triangle.get(n-1);
        for(int i = 0; i < dp.length; i++){
            dp[i] = last.get(i);
        }
        for(int i = n - 2; i >= 0; i--){
            List<Integer> arr = triangle.get(i);
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + arr.get(j);
            }
        }
        return dp[0];
    }
}