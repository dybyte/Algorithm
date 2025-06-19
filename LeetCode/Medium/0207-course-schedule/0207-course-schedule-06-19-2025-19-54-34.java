class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] visited = new int[numCourses];
        for(int[] p : prerequisites){
            int from = p[1];
            int to = p[0];
            graph.get(from).add(to);
            visited[to]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(visited[i]==0) queue.offer(i);
        }

        int count = 0;
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            count++;
            for(int next : graph.get(poll)){
                visited[next]--;
                if(visited[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }

}