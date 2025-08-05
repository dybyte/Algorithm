class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < prerequisites.length; i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                visited[i] = 2;
                dfs(graph, i, visited, stack);
            }
        }
        if(stack.size() != numCourses) return new int[0];
        int[] ans = new int[numCourses];
        for(int i = 0; i < ans.length; i++){
            ans[i] = stack.pop();
        }
        return ans;
    }

    void dfs(List<List<Integer>> graph, int cur, int[] visited, Deque<Integer> stack){
        // 0 : 방문 안함
        // 1 : 방문 중
        // 2 : 방문 완료
        visited[cur] = 2;
        for(int next : graph.get(cur)){
            if(visited[next] == 1) return;
            if(visited[next] == 0){
                visited[next] = 1;
                dfs(graph, next, visited, stack);
            }
        }
        stack.push(cur);
    }
}