import java.io.*;
import java.util.*;

public class Main {
    public static long solution(int[][] arr) {
        int count = 0;
        while (true) {
            boolean exist = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 0) arr[i][j] = -1;
                    else if (arr[i][j] > 0) exist = true;
                }
            }
            if (!exist) return 0;
            boolean one = false;
            boolean[][] visited = new boolean[arr.length][arr[0].length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] > 0) {
                        if (!one) {
                            dfs(i, j, arr, visited);
                            one = true;
                        } else if (!visited[i][j]) return count;
                    }
                }
            }
            count++;
        }
    }

    private static void dfs(int i, int j, int[][] arr, boolean[][] visited) {
        visited[i][j] = true;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
                if (arr[x][y] >= 0 && !visited[x][y]) {
                    dfs(x, y, arr, visited);
                } else if (arr[x][y] == -1) {
                    if (arr[i][j] > 0) arr[i][j]--;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        System.out.println(solution(arr));
    }
}