import java.io.*;
import java.util.*;

public class Main {
    public int solution(int x, int k) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        queue.offer(new int[]{x, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            if (cur == k) return poll[1];
            int[] dx = new int[]{cur + 1, cur - 1, 2 * cur};
            for (int i = 0; i < dx.length; i++) {
                int tmp = dx[i];
                if (tmp >= 0 && tmp < visited.length && !visited[tmp]) {
                    visited[tmp] = true;
                    queue.offer(new int[]{tmp, poll[1] + 1});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        System.out.println(T.solution(n, k));
    }
}