class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));    
        }
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        for(int i = 0; i < dp.length; i++) dp[i][0] = true;
        for(int i = 0 ; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(set.contains(s.substring(i,j+1))) {
                    for(int k = 1; k <= s.length(); k++){
                        if(dp[k][i]) {
                            dp[i+1][j+1] = true;
                            break;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < dp.length; i++){
            if(dp[i][s.length()]) return true;
        }
        return false;
    }
}