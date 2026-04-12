class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //문자열 개수 n, 각 문자의 길이 k
        //n * k
        /**
        - 1 <= strs.length <= 10^4
        - 0 <= strs[i].length <= 100
        - 소문자로 구성되어있음

        anagrams
        - 같은 종류의 문자로 구성되어있다는 것
        -> 문자열을 정렬(klogk)하면 똑같은 결과를 얻을 수 있습니다.
        n * klogk

        - hashmap (String(정렬한 뒤의 문자열), ArrayList<String>)

         */
         Map<String, List<String>> map = new HashMap<>();
         

        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            int[] arr = new int['a'-'A'];
            for(char c : s.toCharArray()){
                arr[c -'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for(int count : arr){
                keyBuilder.append(count).append(".");
            }
            String key = keyBuilder.toString();

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }

        List<List<String>> answer = new ArrayList<>();

        for(String key : map.keySet()){
            List<String> list = map.get(key);
            answer.add(list);
        }

        return answer;
    }
}