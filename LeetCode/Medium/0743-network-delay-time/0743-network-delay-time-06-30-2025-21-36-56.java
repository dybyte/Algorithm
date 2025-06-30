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
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            graph.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Node::compareTo);
        pq.offer(new Node(k,0));


        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int v = cur.vertex;
            int t = cur.time;

            if(t > dist[v]) continue;

            for(Node next : graph.get(v)){
                int newTime = t + next.time;
                if(newTime < dist[next.vertex]){
                    dist[next.vertex] = newTime;
                    pq.offer(new Node(next.vertex, newTime));
                }
            }
        }
        int max = 0;
        for(int i = 1; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}