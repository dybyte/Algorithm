class Solution {
    int[] answer;
    int[] quiet;
    List<Integer>[] adj;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        this.quiet = quiet;
        this.answer = new int[n];
        this.adj = new ArrayList[n];
        
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] r : richer) {
            adj[r[1]].add(r[0]);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        
        return answer;
    }

    private int dfs(int node) {
        if (answer[node] != -1) {
            return answer[node];
        }
        
        answer[node] = node;
        for (int richerNode : adj[node]) {
            int candidate = dfs(richerNode);
            if (quiet[candidate] < quiet[answer[node]]) {
                answer[node] = candidate;
            }
        }
        
        return answer[node];
    }
}