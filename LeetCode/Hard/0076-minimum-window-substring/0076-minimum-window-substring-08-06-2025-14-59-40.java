class Solution {
    public String minWindow(String s, String t) {
        String answer = "";
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i) - '0', false);
        }
        int count = t.length();
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            if(!map.getOrDefault(s.charAt(r) - '0', true)){
                count--;
                map.put(s.charAt(r) - '0', true);
            }
            if(count == 0) {
                if(answer.length() == 0 || answer.length() > r - l + 1) answer = s.substring(l, r+1);
                for(int i = 0; i < t.length(); i++){
                    map.put(t.charAt(i) - '0', false);
                }
                l++;
                while(l < s.length() && !map.containsKey(s.charAt(l) - '0')) l++;
                r = l;
                count = t.length();
            } else {
                r++;
            }
        }
        return answer;
    }
}