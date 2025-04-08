import java.io.*;
import java.util.*;

public class Main {
    public long solution(int[] arr) {
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!stack.isEmpty() && stack.peek() > arr[i]) answer++;
            else {
                int left = 0;
                int right = stack.size() - 1;
                int tmp = stack.size();
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (stack.get(mid) > arr[i]) {
                        tmp = stack.size() - mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                answer += tmp;
            }
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            stack.push(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(T.solution(arr));
    }
}