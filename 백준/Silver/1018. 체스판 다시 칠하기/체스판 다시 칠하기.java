import java.io.*;
import java.util.*;

public class Main {
    public int solution(char[][] board) {
        int[] answer = new int[2];
        char[] arr = new char[]{'B', 'W'};
        int min = 64;
        for (int startRow = 0; startRow + 7 < board.length; startRow++) {
            for (int startCol = 0; startCol + 7 < board[0].length; startCol++) {
                answer[0] = 0;
                answer[1] = 0;
                for (int x = 0; x < 2; x++) {
                    int tmp = x;
                    for (int i = startRow; i < startRow + 8; i++) {
                        int idx = tmp++ % 2;
                        for (int j = startCol; j < startCol + 8; j++) {
                            if (arr[idx++ % 2] != board[i][j]) answer[x]++;
                        }
                    }
                }
                min = Math.min(min, Math.min(answer[0], answer[1]));
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        System.out.println(T.solution(arr));
    }
}