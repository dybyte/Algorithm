class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] word = new int['z' - 'a' + 1];
        for(String s : strs){
            word = new int['z' - 'a' + 1];
            for(int i = 0; i < s.length(); i++){
                word[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < word.length; i++){
                sb.append(word[i]).append(" ");
            }
            String key = sb.toString();
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return map.values().stream().toList();
    }
}