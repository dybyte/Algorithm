import java.io.*;
import java.util.*;

public class Main {
    public static int solution(int[] arr, int m) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < m) left = mid + 1;
            else if (arr[mid] > m) right = mid - 1;
            else return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(solution(arr, Integer.parseInt(token.nextToken()))).append("\n");
        }
        System.out.println(sb);
    }
}
