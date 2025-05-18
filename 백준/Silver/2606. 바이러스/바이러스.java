import java.io.*;
import java.util.*;

public class Main {
    int count = -1;

    public int solution(int n, boolean[][] arr) {
        boolean[] visited = new boolean[n + 1];
        dfs(visited, arr, 1);
        return count;
    }

    void dfs(boolean[] visited, boolean[][] arr, int cur) {
        visited[cur] = true;
        count++;
        for (int i = 1; i < arr.length; i++) {
            if (!visited[i] && arr[i][cur]) dfs(visited, arr, i);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(token.nextToken());
            int second = Integer.parseInt(token.nextToken());
            arr[first][second] = arr[second][first] = true;
        }
        System.out.println(T.solution(n, arr));
    }
}