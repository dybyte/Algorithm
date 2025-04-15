import java.io.*;
import java.util.*;

public class Main {
    public long solution(int[] arr, int n) {
        long answer = 0;
        int left = 0;
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            while (set.contains(arr[right])) {
                set.remove(arr[left++]);
            }
            set.add(arr[right]);
            answer += (right - left + 1);
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
        System.out.println(T.solution(arr, n));
    }
}