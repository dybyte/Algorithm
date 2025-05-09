import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean decimal = false;
            for (int j = 2; j < arr[i]; j++) {
                if (arr[i] % j == 0) {
                    decimal = false;
                    break;
                }
                decimal = true;
            }
            if (decimal) answer++;
            else if (arr[i] == 2) answer++;
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
        System.out.println(T.solution(arr));
    }
}