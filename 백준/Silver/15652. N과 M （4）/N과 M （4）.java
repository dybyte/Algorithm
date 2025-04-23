import java.io.*;
import java.util.*;

public class Main {
    public StringBuilder solution(int n, int m) {
        StringBuilder sb = new StringBuilder("");
        boolean[] visited = new boolean[n + 1];
        dfs(visited, new ArrayList<>(), n, m, 0, sb);
        return sb;
    }

    public void dfs(boolean[] visited, List<Integer> arr, int n, int m, int idx, StringBuilder sb) {
        if (idx == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        int start = arr.isEmpty() ? 1 : arr.get(arr.size() - 1);
        for (int i = start; i <= n; i++) {
            visited[i] = true;
            arr.add(i);
            dfs(visited, arr, n, m, idx + 1, sb);
            visited[i] = false;
            arr.remove(idx);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        System.out.println(T.solution(n, m));
    }
}