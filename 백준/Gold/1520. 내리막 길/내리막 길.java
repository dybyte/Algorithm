import java.io.*;
import java.util.*;

public class Main {
    public static long solution(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, arr, dp);
    }

    private static int dfs(int i, int j, int[][] arr, int[][] dp) {
        if (i == arr.length - 1 && j == arr[0].length - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = 0;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
                if (arr[x][y] < arr[i][j]) {
                    dp[i][j] += dfs(x, y, arr, dp);
                }
            }
        }
        return dp[i][j];
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