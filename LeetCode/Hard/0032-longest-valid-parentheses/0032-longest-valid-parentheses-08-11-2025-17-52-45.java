class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    int tmp = i >= 2 ? dp[i-2] : 0;
                    dp[i] = tmp + 2;
                } else if(i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){ // ))
                    int tmp = i - dp[i-1] - 2 >= 0 ? dp[i - dp[i-1] - 2] : 0;
                    dp[i] = dp[i-1] + 2 + tmp;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}