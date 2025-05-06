import java.io.*;
import java.util.*;

public class Main {
    public long solution(int m, int[] arr) {
        long answer = 0;
        int[] sum = new int[arr.length + 1];
        int[] count = new int[m];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = (arr[i - 1] + sum[i - 1]) % m;
            count[sum[i]]++;
        }
        answer += count[0];
        for (int i = 0; i < count.length; i++) {
            long tmp = count[i];
            answer += (tmp * (tmp - 1)) / 2;
        }
        return answer;
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
        System.out.println(T.solution(m, arr));
    }
}