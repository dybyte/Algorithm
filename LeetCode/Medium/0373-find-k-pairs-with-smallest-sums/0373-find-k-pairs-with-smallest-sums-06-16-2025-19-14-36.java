class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (k > 0 && !pq.isEmpty()) {
            int[] poll = pq.poll();
            int x = poll[0], y = poll[1];
            answer.add(List.of(nums1[x], nums2[y]));
            if (y + 1 < nums2.length) {
                pq.offer(new int[]{x, y + 1});
            }
            --k;
        }
        return answer;
    }
}