import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] arr, int x) {
        int answer = 0;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < x) left++;
            else if (arr[left] + arr[right] > x) right--;
            else {
                answer++;
                left++;
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        System.out.println(T.solution(arr, x));
    }
}