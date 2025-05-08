import java.io.*;
import java.util.*;

public class Main {
    public StringBuilder solution(int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder("");
        Arrays.sort(arr1);
        int[] arr = new int[arr1.length + 1];
        arr[arr.length - 2] = 1;
        for (int i = arr1.length - 2; i >= 0; i--) {
            arr[i]++;
            if (arr1[i + 1] == arr1[i]) arr[i] = arr[i + 1] + 1;
        }
        for (int i = 0; i < arr2.length; i++) {
            int left = 0;
            int right = arr1.length - 1;
            int answer = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr1[mid] > arr2[i]) {
                    right = mid - 1;
                } else if (arr1[mid] < arr2[i]) {
                    left = mid + 1;
                } else {
                    answer = mid;
                    right = mid - 1;
                }
            }
            sb.append(arr[answer] + " ");
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(token.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(arr1, arr2));
    }
}