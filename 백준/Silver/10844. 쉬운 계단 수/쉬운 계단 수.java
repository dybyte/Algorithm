import java.io.*;

public class Main {
    public static long solution(int n) {
        long mod = 1_000_000_000;
        int[][] arr = new int[10][n + 1];
        for (int i = 1; i <= 9; i++) {
            arr[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) arr[j][i] += arr[j - 1][i - 1];
                if (j < 9) arr[j][i] += arr[j + 1][i - 1];
                arr[j][i] %= mod;
            }
        }
        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (int) ((answer + arr[i][n]) % mod);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}
