class Solution {
    public int leastInterval(char[] tasks, int n) {
        //idle 상태를 최소화
        //tasks 내에 개수가 많을수록 휴식기로 갈 확률이 높습니다. AAAAAAADD
        // -> 개수가 많은 프로세스를 먼저 실행해야한다. (쉬는타임이 끝난 프로세스 기준)

        //개수가 많은 프로세스를 먼저 실행하기 위해서 heap
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks) map.put(c, map.getOrDefault(c, 0)+1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        Queue<int[]> cooldown = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !cooldown.isEmpty()){
            time++;

            if(!pq.isEmpty()){
                int poll = pq.poll();
                if(poll - 1 > 0) cooldown.add(new int[]{poll-1, time+n});
            }
            

            while(!cooldown.isEmpty() && cooldown.peek()[1] == time){
                pq.offer(cooldown.poll()[0]);
            }
        }
        return time;
    }
}