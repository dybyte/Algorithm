import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] arr, int n, int m) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) queue.offer(new int[]{i, j});
            }
        }
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0) {
                    arr[x][y] = arr[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) return -1;
                answer = Math.max(answer, arr[i][j]);
            }
        }
        return --answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        System.out.println(T.solution(arr, m, n));
    }
}