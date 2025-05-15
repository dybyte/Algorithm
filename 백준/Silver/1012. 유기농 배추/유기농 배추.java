import java.io.*;
import java.util.*;

public class Main {
    public int solution(boolean[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] && !visited[i][j]) {
                    dfs(arr, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(boolean[][] arr, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
                if (arr[x][y] && !visited[x][y]) dfs(arr, visited, x, y);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            int k = Integer.parseInt(token.nextToken());
            boolean[][] arr = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                token = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())] = true;
            }
            sb.append(T.solution(arr)).append("\n");
        }
        System.out.println(sb);
    }
}