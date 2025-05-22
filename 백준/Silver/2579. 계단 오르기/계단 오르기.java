import java.io.*;

public class Main {
    public static int solution(int[] arr) {
        int[] dp = new int[arr.length + 2];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i - 2], dp[i - 3] + arr[i - 3] + arr[i - 2]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(arr));
    }
}
