class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));    
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0 ; i < s.length(); i++){
            if(!dp[i]) continue;
            for(int j = i; j < s.length(); j++){
                if(set.contains(s.substring(i,j+1))) {
                    dp[j+1] = true;
                }
            }
        }
        return dp[dp.length-1];
    }
}