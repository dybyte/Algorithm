class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
        HashMap<Integer, Integer>
        key : array number
        value : number count

        - 배열을 1번 돌면서
        map을 채움

        - map의 value를 모두 꺼내서 top k 만큼의 map entry를 찾는다.
        이 map entry들의 key 값을 배열에 담아서 반환.

         */

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