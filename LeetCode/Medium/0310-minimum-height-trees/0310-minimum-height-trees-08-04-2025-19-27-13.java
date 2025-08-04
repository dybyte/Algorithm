class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            answer.add(i);
        }
        for(int i = 0; i < edges.length; i++){
            List<Integer> list1 = graph.get(edges[i][0]);
            list1.add(edges[i][1]);
            List<Integer> list2 = graph.get(edges[i][1]);
            list2.add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 1) queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            answer = new ArrayList<>();

            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                answer.add(cur);
                for(int next : graph.get(cur)){
                    indegree[next]--;
                    if(indegree[next] == 1) queue.offer(next);
                }
            }
        }

        return answer;
    }
}