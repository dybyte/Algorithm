import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder solution(int[] arr) {
        StringBuilder sb = new StringBuilder("");
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (!pq.isEmpty()) sb.append(pq.poll()).append("\n");
                else sb.append("0").append("\n");
            } else pq.offer(arr[i]);
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(arr));
    }
}