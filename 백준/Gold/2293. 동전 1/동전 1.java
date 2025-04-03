import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] arr, int n, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            for (int j = 0; j + tmp <= k; j++) {
                dp[j + tmp] += dp[j];
            }
        }
        return dp[k];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(T.solution(arr, n, k));
    }
}