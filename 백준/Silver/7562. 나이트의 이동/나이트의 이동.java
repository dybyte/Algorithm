import java.io.*;
import java.util.*;

public class Main {
    int[] destination = new int[2];
    StringBuilder sb = new StringBuilder("");

    public void solution(int n, int[][] arr) {
        boolean[][] visited = new boolean[n][n];
        destination[0] = arr[1][0];
        destination[1] = arr[1][1];
        bfs(visited, arr[0][0], arr[0][1], 0);
    }

    void bfs(boolean[][] visited, int i, int j, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, count});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == destination[0] && poll[1] == destination[1]) {
                sb.append(poll[2]).append("\n");
                return;
            }
            int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
            int[] dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};
            for (int k = 0; k < 8; k++) {
                int x = poll[0] + dx[k];
                int y = poll[1] + dy[k];
                if (x >= 0 && x < visited.length && y >= 0 && y < visited.length) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y, poll[2] + 1});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][2];
        for (int i = 0; i < x; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer token = new StringTokenizer(br.readLine());
            arr[0][0] = Integer.parseInt(token.nextToken());
            arr[0][1] = Integer.parseInt(token.nextToken());
            token = new StringTokenizer(br.readLine());
            arr[1][0] = Integer.parseInt(token.nextToken());
            arr[1][1] = Integer.parseInt(token.nextToken());
            T.solution(n, arr);
        }
        System.out.println(T.sb);
    }
}