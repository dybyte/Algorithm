import java.io.*;
import java.util.*;

public class Main {
    public long solution(int[] arr1, int[] arr2) {
        int num = arr2[0];
        int count = 0;
        int answer = arr2[0] * arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            if (arr2[i] < num) {
                answer += num * count;
                num = arr2[i];
                count = arr1[i];
            } else {
                count += arr1[i];
            }
        }
        return answer + count * num;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int[] arr1 = new int[n - 1];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = Integer.parseInt(token.nextToken());
        }
        int[] arr2 = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(arr1, arr2));
    }
}