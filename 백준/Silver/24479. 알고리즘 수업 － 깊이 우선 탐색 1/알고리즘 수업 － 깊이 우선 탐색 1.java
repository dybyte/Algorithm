import java.io.*;
import java.util.*;

public class Main {
    int count = 0;
    Map<Integer, PriorityQueue<Integer>> graph = new HashMap<>();

    public StringBuilder solution(int[][] arr, int n, int r) {
        int[] answer = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < arr.length; i++) {
            int one = arr[i][0];
            int two = arr[i][1];
            PriorityQueue<Integer> pq1 = graph.getOrDefault(one, new PriorityQueue<>());
            PriorityQueue<Integer> pq2 = graph.getOrDefault(two, new PriorityQueue<>());
            pq1.offer(two);
            pq2.offer(one);
            graph.put(one, pq1);
            graph.put(two, pq2);
        }
        dfs(answer, visited, r);
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }
        return sb;
    }

    void dfs(int[] answer, boolean[] visited, int i) {
        visited[i] = true;
        answer[i] = ++count;
        PriorityQueue<Integer> priorityQueue = graph.get(i);
        while (priorityQueue != null && !priorityQueue.isEmpty()) {
            int poll = priorityQueue.poll();
            if (!visited[poll]) dfs(answer, visited, poll);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int r = Integer.parseInt(token.nextToken());
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(arr, n, r));
    }
}