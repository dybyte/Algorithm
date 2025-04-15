import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] arr, int n) {
        int answer = 0;
        int max = 0;
        int maxIdx = 0;
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            if (max < arr[i][1]) {
                max = arr[i][1];
                maxIdx = i;
            }
        }
        int savePoint = 0;
        for (int i = 1; i <= maxIdx; i++) {
            if (arr[i][1] >= arr[savePoint][1]) {
                answer += (arr[i][0] - arr[i - 1][0]) * arr[i - 1][1];
                savePoint = i;
            } else {
                arr[i][1] = arr[savePoint][1];
                arr[i][0] = arr[savePoint][0];
            }
        }
        savePoint = maxIdx;
        for (int i = maxIdx + 1; i < n; i++) {
            boolean check = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j][1] > arr[i][1]) {
                    check = false;
                    break;
                }
            }
            if (check && arr[i][1] >= arr[n - 1][1] && arr[i][1] <= arr[savePoint][1]) {
                answer += (arr[i][0] - arr[savePoint][0]) * arr[i][1];
                savePoint = i;
            } else {
                arr[i][1] = arr[savePoint][1];
                arr[i][0] = arr[savePoint][0];
            }
        }
        return answer + max;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(arr, n));
    }
}