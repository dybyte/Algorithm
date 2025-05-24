import java.io.*;
import java.util.*;

public class Main {
    public static long solution(PriorityQueue<int[]> arr1, PriorityQueue<Integer> arr2) {
        long sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        while (!arr2.isEmpty()) {
            int poll = arr2.poll();
            while (!arr1.isEmpty()) {
                int[] arr = arr1.peek();
                if (arr[0] > poll) break;
                pq.offer(arr1.poll());
            }
            if (!pq.isEmpty()) sum += pq.poll()[1];
        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())});
        }
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            pq2.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(solution(pq, pq2));
    }
}