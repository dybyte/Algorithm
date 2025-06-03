class Solution {
    public String longestPalindrome(String s) {
        String answer = s.substring(0,1);
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int end = 0; end < s.length(); end++){
            for(int start = 0; start <= end; start++){
                if(s.charAt(end) == s.charAt(start) && (end - start + 1 < 4 || dp[start+1][end-1])){
                    dp[start][end] = true;
                    if(end - start + 1 > answer.length()) answer = s.substring(start,end+1);
                }
            }
        }
        return answer;
    }
}