import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    int sum = 0;
    int count = 0;

    public StringBuilder solution(boolean[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] && !visited[i][j]) {
                    dfs(arr, visited, i, j);
                    sum++;
                    answer.add(count);
                    count = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        sb.append(sum).append("\n");
        answer = answer.stream().sorted().collect(Collectors.toList());
        for (int i : answer) sb.append(i).append("\n");
        return sb;
    }

    void dfs(boolean[][] arr, boolean[][] visited, int i, int j) {
        count++;
        visited[i][j] = true;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < arr.length && y >= 0 && y < arr.length) {
                if (arr[x][y] && !visited[x][y]) dfs(arr, visited, x, y);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = chars[j] == '1' ? true : false;
            }
        }
        System.out.println(T.solution(arr));
    }
}