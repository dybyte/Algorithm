class Solution {
    class Node {
        int vertex;
        int time;
        Node(int vertex, int time){
            this.vertex = vertex;
            this.time = time;
        }
        public int compareTo(Node other){
            return this.time - other.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> graph = new ArrayList<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList());
        }
        for(int i = 0; i < times.length; i++){
            graph.get(times[i][0]).add(new Node(times[i][1],times[i][2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Node::compareTo);
        distance[k] = 0;
        pq.offer(new Node(k,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.time > distance[cur.vertex]) continue;

            for(Node next : graph.get(cur.vertex)){
                int time = next.time + cur.time;
                if(time >= distance[next.vertex]) continue;
                distance[next.vertex] = time;
                pq.offer(new Node(next.vertex, time));
            }
        }
        int max = 0;
        for(int i = 1; i < distance.length; i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distance[i]);
        }
        return max;
    }
}