import java.io.*;
import java.util.*;

public class Main {
    public long solution(int[] arr, int k) {
        int[] sum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i + k - 1 < sum.length; i++) {
            answer = Math.max(answer, sum[i + k - 1] - sum[i - 1]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int[] arr = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(arr, k));
    }
}