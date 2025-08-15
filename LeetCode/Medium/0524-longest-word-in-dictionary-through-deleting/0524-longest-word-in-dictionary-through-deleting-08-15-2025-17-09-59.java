class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String answer = "";
        for(int i = 0; i < dictionary.size(); i++){
            int wordIdx = 0;
            String word = dictionary.get(i);
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == word.charAt(wordIdx)){
                    if(wordIdx == word.length() - 1) {
                        if(answer.length() < word.length()){
                            answer = word;
                        } else if(answer.length() == word.length()
                        && answer.compareTo(word) > 0){
                            answer = word;
                        }
                        break;
                    }
                    wordIdx++;
                }
            }
        }
        return answer;
    }
}