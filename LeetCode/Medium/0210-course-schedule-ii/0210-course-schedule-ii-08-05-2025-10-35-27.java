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
            if(indegree[i] == 0) queue.offer(i);
        }
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int poll = queue.poll();
            answer.add(poll);
            for(int next : graph.get(poll)){
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
        }
        if(answer.size() != numCourses) return new int[0];
        int[] ans = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}