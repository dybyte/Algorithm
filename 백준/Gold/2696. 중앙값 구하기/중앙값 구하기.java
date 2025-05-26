import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder solution(int[] arr) {
        int count = 0;
        StringBuilder sb = new StringBuilder("");
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();//중앙값보다 큰 경우
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);//중앙값보다 작거나 같은 경우
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (maxPQ.isEmpty() || num <= maxPQ.peek()) {
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }

            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.offer(maxPQ.poll());
            } else if (maxPQ.size() < minPQ.size()) {
                maxPQ.offer(minPQ.poll());
            }

            if (i % 2 == 0) {
                sb.append(maxPQ.peek()).append(" ");
                if (++count == 10) {
                    count = 0;
                    sb.append("\n");
                }
            }
        }
        return sb;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int idx = 0;
            while (idx < n) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                while (token.hasMoreTokens()) {
                    arr[idx] = Integer.parseInt(token.nextToken());
                    idx++;
                }
            }
            sb.append(n / 2 + 1).append("\n").append(solution(arr)).append("\n");
        }
        System.out.println(sb);
    }
}