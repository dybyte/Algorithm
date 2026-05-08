class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdegree = new int[graph.length];
        List<List<Integer>> outGraph = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            outGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                outdegree[i]++;
                outGraph.get(graph[i][j]).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < outdegree.length; i++){
            if(outdegree[i] == 0) queue.offer(i);
        }

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int poll = queue.poll();
            list.add(poll);
            for(int next : outGraph.get(poll)){
                outdegree[next]--;
                if(outdegree[next] == 0) queue.offer(next);
            }
        }

        Collections.sort(list);
        return list;
    }
}