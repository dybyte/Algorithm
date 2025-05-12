import java.io.*;
import java.util.*;

public class Main {
    public StringBuilder solution(boolean[][] arr, int n, int v) {
        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder("");
        dfs(arr, visited, v, sb);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(arr, visited, v, sb);
        return sb;
    }

    void dfs(boolean[][] arr, boolean[] visited, int i, StringBuilder sb) {
        visited[i] = true;
        sb.append(i).append(" ");
        for (int j = 1; j < arr.length; j++) {
            if (arr[i][j] && !visited[j]) dfs(arr, visited, j, sb);
        }
    }

    void bfs(boolean[][] arr, boolean[] visited, int v, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            for (int i = 1; i < arr.length; i++) {
                if (arr[node][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int r = Integer.parseInt(token.nextToken());
        boolean[][] arr = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(token.nextToken());
            int two = Integer.parseInt(token.nextToken());
            arr[one][two] = arr[two][one] = true;
        }
        System.out.println(T.solution(arr, n, r));
    }
}