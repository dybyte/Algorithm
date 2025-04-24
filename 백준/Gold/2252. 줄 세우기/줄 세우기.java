import java.io.*;
import java.util.*;

public class Main {
    Deque<Integer> answer = new ArrayDeque<>();

    public StringBuilder solution(int[][] arr, int n) {
        boolean[] visited = new boolean[n + 1];
        Map<Integer, List<Integer>> line = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            line.put(i, new ArrayList<>());
        }
        for (int[] edge : arr) {
            line.get(edge[0]).add(edge[1]);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) dfs(line, visited, i);
        }

        StringBuilder sb = new StringBuilder("");
        while (!answer.isEmpty()) {
            sb.append(answer.pop()).append(" ");
        }
        return sb;
    }

    private void dfs(Map<Integer, List<Integer>> line, boolean[] visited, int i) {
        visited[i] = true;
        for (int node : line.get(i)) {
            if (!visited[node]) dfs(line, visited, node);
        }
        answer.push(i);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(arr, n));
    }
}