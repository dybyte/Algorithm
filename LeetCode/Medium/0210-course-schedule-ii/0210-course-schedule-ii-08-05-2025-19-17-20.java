class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < prerequisites.length; i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i]==0) queue.offer(i);
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans[idx++] = cur;
            for(int next : graph.get(cur)){
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
        }
        if(idx != numCourses) return new int[0];
        return ans;
    }
}