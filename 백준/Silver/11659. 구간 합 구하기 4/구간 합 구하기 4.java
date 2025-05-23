import java.io.*;
import java.util.*;

public class Main {
    public StringBuilder solution(int[] arr, int[][] sum) {
        int[] history = new int[arr.length + 1];
        for (int i = 1; i < history.length; i++) {
            history[i] = history[i - 1] + arr[i - 1];
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < sum.length; i++) {
            sb.append(history[sum[i][1]] - history[sum[i][0] - 1]).append("\n");
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[] arr = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int[][] sum = new int[m][2];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            sum[i][0] = Integer.parseInt(token.nextToken());
            sum[i][1] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(arr, sum));
    }
}