class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        /**
            해시테이블 -> key value?? 

            KEY -> 
            int[] count = new int[26]; -> 각 알파벳의 횟수
            [1, 1, 0,,,,0,] -> a 1, b 1, 나머지는 다 0번 

            이 배열을 키로 잡음

            ab, ba, bc 

            *** 각 알파벳을 구분해주는 구분자 '#'
            a 11, b 1 11#1#0#0#0#
            a 1, b 11 1#11#0#0#0#0
         */

         // 해시맵 
        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26];

        for(String s : strs) {
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");

            for(int i = 0; i < 26; ++i){
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if(!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}