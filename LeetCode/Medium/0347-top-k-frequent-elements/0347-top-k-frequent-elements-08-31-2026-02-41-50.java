class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            int count = map.getOrDefault(i, 0);
            map.put(i, ++count);
        }


        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (n1, n2) -> n2.getValue() - n1.getValue());

        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}