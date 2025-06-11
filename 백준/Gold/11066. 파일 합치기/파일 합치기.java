import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] arr, int n) {
        int[][] dp = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i][i] = arr[i - 1];
            for (int j = i + 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + arr[j - 1];
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + sum[i][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] arr = new int[m];
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(tokenizer.nextToken());
            }
            sb.append(T.solution(arr, m)).append("\n");
        }
        System.out.println(sb);
    }
}