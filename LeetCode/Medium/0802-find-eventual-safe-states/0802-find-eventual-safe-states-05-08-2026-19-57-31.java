class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 0: 방문 안 함, 1: 방문 중(사이클 위험), 2: 안전함 확인됨
        int[] state = new int[n];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(i, graph, state)) {
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean isSafe(int node, int[][] graph, int[] state) {
        if (state[node] > 0) {
            // 이미 안전하다고 판명(2)됐으면 true, 방문 중(1)이면 사이클이므로 false
            return state[node] == 2;
        }

        // 방문 시작 (현재 경로에 포함됨)
        state[node] = 1;

        for (int next : graph[node]) {
            // 연결된 노드 중 하나라도 안전하지 않으면 이 노드도 안전하지 않음
            if (!isSafe(next, graph, state)) {
                return false;
            }
        }

        // 모든 경로가 무사히 끝나면 안전함(2)으로 표시
        state[node] = 2;
        return true;
    }
}