public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(freqMap.values());

        int time = 0;

        Queue<int[]> cooldown = new ArrayDeque<>();

        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int count = pq.poll() - 1;
                if (count > 0) {
                    cooldown.offer(new int[]{count, time + n});
                }
            }

            while (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                pq.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}