class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // int['z'-'a']
        // 

        List<Integer> answer = new ArrayList<>();

        int[] arr = new int['a'-'A'];
        for(char c : p.toCharArray()){
            arr[c-'a']++;
        }

        for(int i = 0; i < s.length() - p.length() + 1; i++){
            String subString = s.substring(i, i+p.length());

            int[] subArr = new int['a'-'A'];
            for(char c : subString.toCharArray()){
                subArr[c-'a']++;
            }

            boolean isAnagram = true;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] != subArr[j]) {
                    isAnagram = false;
                    break;
                }
            }

            if(isAnagram){
                answer.add(i);
            }
        }

        return answer;
    }
}