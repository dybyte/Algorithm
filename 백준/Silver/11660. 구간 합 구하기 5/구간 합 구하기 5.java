import java.io.*;
import java.util.*;

public class Main {
    public StringBuilder solution(int[][] arr, int[][] request) {
        StringBuilder sb = new StringBuilder("");
        int[][] sum = new int[arr.length + 1][arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sum[i + 1][0] = sum[i][arr.length];
            for (int j = 0; j < arr.length; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + arr[i][j];
            }
        }

        for (int i = 0; i < request.length; i++) {
            int startRow = request[i][0];
            int startCol = request[i][1];
            int endRow = request[i][2];
            int endCol = request[i][3];
            int answer = 0;
            for (int j = startRow; j <= endRow; j++) {
                answer += sum[j][endCol] - sum[j][startCol - 1];
            }
            sb.append(answer).append("\n");
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int[][] request = new int[m][4];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                request[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        System.out.println(T.solution(arr, request));
    }
}