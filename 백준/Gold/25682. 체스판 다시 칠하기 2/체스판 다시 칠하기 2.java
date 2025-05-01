import java.io.*;
import java.util.*;

public class Main {
    public int solution(char[][] arr, int k) {
        int[][] sumB = new int[arr.length + 1][arr[0].length + 1];
        int[][] sumW = new int[arr.length + 1][arr[0].length + 1];
        for (int i = 1; i < sumB.length; i++) {
            int x = i;
            for (int j = 1; j < sumB[0].length; j++) {
                sumB[i][j] = -sumB[i - 1][j - 1] + sumB[i - 1][j] + sumB[i][j - 1];
                sumW[i][j] = -sumW[i - 1][j - 1] + sumW[i - 1][j] + sumW[i][j - 1];
                char tmp = x % 2 == 0 ? 'B' : 'W';
                if (tmp == arr[i - 1][j - 1]) sumB[i][j]++;
                else sumW[i][j]++;
                x++;
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i + k - 1 < sumB.length; i++) {
            for (int j = 1; j + k - 1 < sumB[0].length; j++) {
                answer = Math.min(answer, Math.min(sumB[i + k - 1][j + k - 1] - sumB[i + k - 1][j - 1] - sumB[i - 1][j + k - 1] + sumB[i - 1][j - 1],
                        sumW[i + k - 1][j + k - 1] - sumW[i + k - 1][j - 1] - sumW[i - 1][j + k - 1] + sumW[i - 1][j - 1]));
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        System.out.println(T.solution(arr, k));
    }
}