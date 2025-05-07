import java.io.*;
import java.util.*;

public class Main {
    public long solution(int n, int[] arr) {
        long left = 1;
        long right = Arrays.stream(arr).max().getAsInt();
        long answer = 0;
        while (left <= right) {
            long tmp = 0;
            long mid = (int) (left + (right - left) / 2);
            for (int i = 0; i < arr.length; i++) {
                tmp += arr[i] / mid;
                if (tmp >= n) break;
            }
            if (tmp < n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(T.solution(N, arr));
    }
}