class Solution {
    public int numDecodings(String s) {
        //dp[i](s 0~i 경우의수) -> dp[i-1]   "111/06" s.charAt(i) != '0'
        //      -> dp[i-2] "111/06"  s.substring(i-1, i+1)(i-1, i) 06 -> x  10 <= x <= 26
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) != '0') dp[1] += dp[0];
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != '0') dp[i+1] += dp[i];
            int tmp = Integer.parseInt(s.substring(i-1, i+1));
            if(10 <= tmp && tmp <= 26) dp[i+1] += dp[i-1];
        }
        return dp[s.length()];
    }
}