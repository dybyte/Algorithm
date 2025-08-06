class Solution {
    public String minWindow(String s, String t) {
        int leftAns = 0;
        int rightAns = 0;
        int len = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;
        int have = 0, need = map.size();
        Map<Character, Integer> window = new HashMap<>();
        while(r < s.length()) {
            if(map.containsKey(s.charAt(r))){
                window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
                if(window.get(s.charAt(r)).intValue() == map.get(s.charAt(r)).intValue()){
                    have++;
                }
            }
            while(have==need){
                if(len > r - l + 1) {
                    leftAns = l;
                    rightAns = r;
                    len = r - l + 1;
                }
                if(map.containsKey(s.charAt(l))){
                    window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                    if(window.get(s.charAt(l)).intValue() < map.get(s.charAt(l)).intValue()){
                        have--;
                    }
                }
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(leftAns, rightAns+1);
    }
}