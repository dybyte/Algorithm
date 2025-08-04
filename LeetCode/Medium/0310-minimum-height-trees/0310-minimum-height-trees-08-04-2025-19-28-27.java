class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            answer.add(i);
        }
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 1) queue.offer(i);
        }

      
        while(!queue.isEmpty()){
            answer = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int poll = queue.poll();
                answer.add(poll);
                for(int next : graph.get(poll)){
                    indegree[next]--;
                    if(indegree[next] == 1) queue.offer(next);
                }
            }
        }
        return answer;
    }
}