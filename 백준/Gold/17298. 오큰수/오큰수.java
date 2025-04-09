import java.io.*;
import java.util.*;

public class Main {
    public StringBuilder solution(int[] arr) {
        StringBuilder sb = new StringBuilder("");
        int[] answer = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int pop = stack.pop();
                answer[pop] = arr[i];
            }
            stack.push(i);
        }
        for (int i : answer) {
            i = i == 0 ? -1 : i;
            sb.append(i).append(" ");
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(arr));
    }
}