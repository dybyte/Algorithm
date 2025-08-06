class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int leftAns = 0;
        int rightAns = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int l = 0;
        int have = 0, need = tMap.size();
        for(int r = 0; r < s.length(); r++){
            if(tMap.containsKey(s.charAt(r))){
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
                if(tMap.get(s.charAt(r)).intValue() == sMap.get(s.charAt(r)).intValue()){
                    have++;
                }
            }
            while (have == need){
                if(minLen > r - l + 1) {
                    minLen = r - l + 1;
                    leftAns = l;
                    rightAns = r;
                }
                if(tMap.containsKey(s.charAt(l))){
                    sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                    if(tMap.get(s.charAt(l)).intValue() > sMap.get(s.charAt(l)).intValue()){
                        have--;
                    }
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(leftAns, rightAns + 1);
    }
}