import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] arr, int start, int end) {
        int[] left = new int[end + 1];
        int[] right = new int[end + 2];
        for (int i = start; i <= end; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        for (int i = end; i >= start; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        int answer = 0;
        for (int i = start; i <= end; i++) {
            answer += Math.min(left[i], right[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][2];
        int[] arr = new int[1001];
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(token.nextToken());
            input[i][1] = Integer.parseInt(token.nextToken());
            arr[input[i][0]] = input[i][1];
        }
        Arrays.sort(input, Comparator.comparingInt(a -> a[0]));
        System.out.println(T.solution(arr, input[0][0], input[n - 1][0]));
    }
}