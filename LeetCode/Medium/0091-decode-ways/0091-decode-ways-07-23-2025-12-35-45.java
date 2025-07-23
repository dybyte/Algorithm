class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        int first =Integer.parseInt(String.valueOf(s.charAt(0)));
        dp[0] = 1;
        if(s.charAt(0)!='0') dp[1] = 1;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i)!='0') dp[i+1] += dp[i];
            int tmp = Integer.parseInt(s.substring(i-1,i+1));
            if(10 <= tmp && tmp <= 26) dp[i+1] += dp[i-1];
        }
        return dp[s.length()];
    }
}