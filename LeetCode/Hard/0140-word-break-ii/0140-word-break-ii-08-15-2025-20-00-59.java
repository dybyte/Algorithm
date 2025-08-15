class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //StringBuilder sb = new StringBuilder("");
        Map<Integer, List<String>> map = new HashMap<>();
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> dict = new HashSet<>();
        for(String word : wordDict) dict.add(word);
        dp[0] = true;
        for(int i = 0; i < s.length(); i++) {
            if(!dp[i]) continue;
            for(int j = i + 1; j <= s.length(); j++){
                String tmp = s.substring(i, j);
                if(dict.contains(tmp)){
                    dp[j] = true;
                    List<String> sbList = map.getOrDefault(i, List.of(""));
                    List<String> sbList1 = new ArrayList<>();
                
                    for(String s1 : sbList){
                        String s2 = s1 + tmp;
                        if(j < s.length()) s2 += " ";
                        System.out.println(s2);
                        sbList1.add(s2);
                    }
                    sbList = map.getOrDefault(j, new ArrayList<>());    
               
                    for(String s1 : sbList1) sbList.add(s1);
                    map.put(j, sbList);
                    
                }
                
            }
          //  map.remove(i);
        }
        return map.getOrDefault(s.length(), new ArrayList<>());
    
    }
}