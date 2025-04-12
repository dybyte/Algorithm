import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] arr, int n, int m) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i - 1][j - 1] == 0)
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer token1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(token1.nextToken());
            }
        }
        System.out.println(T.solution(arr, n, m));
    }
}