import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public int solution(int[][] maze, int n, int m) {
        Queue<Position> positions = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        boolean[][] broken = new boolean[n][m];
        positions.offer(new Position(0, 0, 1, 1));
        while (!positions.isEmpty()) {
            Position poll = positions.poll();
            if (poll.x == n - 1 && poll.y == m - 1) return poll.count;
            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    if (maze[nx][ny] == 1 && poll.chance == 1) {
                        visited[nx][ny] = true;
                        positions.offer(new Position(nx, ny, poll.count + 1, 0));
                    } else if (maze[nx][ny] == 0) {
                        if (poll.chance == 1) visited[nx][ny] = true;
                        else if (broken[nx][ny]) continue;
                        else broken[nx][ny] = true;
                        positions.offer(new Position(nx, ny, poll.count + 1, poll.chance));
                    }
                }
            }
        }
        return -1;
    }

    public class Position {
        int x;
        int y;
        int count;
        int chance;

        public Position(int x, int y, int count, int chance) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.chance = chance;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int solution = T.solution(arr, N, M);
        System.out.println(solution);
    }
}