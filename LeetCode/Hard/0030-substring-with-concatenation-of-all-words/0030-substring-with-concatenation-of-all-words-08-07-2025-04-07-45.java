class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        int len = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        for(String w : words){
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }
     

        for(int i = 0; i < len; i++){
            Map<String, Integer> window = new HashMap<>();
            int l = i, r = i;
            int have = 0;
            while(r + len <= s.length()){
                String word = s.substring(r, r+len);
                r += len;
                if(!wordMap.containsKey(word)){
                    l = r;
                    have = 0;
                    window.clear();
                    continue;
                }
                window.put(word, window.getOrDefault(word, 0) + 1);
                have++;
                

                while (window.get(word) > wordMap.get(word)) {
                    String leftWord = s.substring(l, l + len);
                    window.put(leftWord, window.get(leftWord) - 1);
                    have--;
                    l += len;
                }

                if (have == words.length) {
                    answer.add(l);
                }
            }
        }
        return answer;
    }
}