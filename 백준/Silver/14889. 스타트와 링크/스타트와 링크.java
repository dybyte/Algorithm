import java.io.*;
import java.util.*;

public class Main {
    static int[][] score;
    static int n;
    static int answer = 9000;

    public static void dfs(int idx, int depth, boolean[] visited) {
        if (depth == n / 2) {
            int teamA = 0, teamB = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        teamA += score[i][j] + score[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        teamB += score[i][j] + score[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(teamA - teamB));
            return;
        }

        for (int i = idx; i < n; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        score = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                score[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        dfs(0, 0, new boolean[n]);
        System.out.println(answer);
    }
}