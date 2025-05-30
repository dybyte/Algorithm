import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder solution(int m, int n) {
        StringBuilder sb = new StringBuilder("");
        boolean[] decimal = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            decimal[i] = true;
            for (int j = 2; j < decimal.length; j++) {
                if (j * j > i) break;
                if (decimal[j] && i % j == 0) {
                    decimal[i] = false;
                    break;
                }
            }
        }
        for (int i = m; i <= n; i++) {
            if (decimal[i]) sb.append(i).append("\n");
        }
        return sb;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());
        System.out.println(solution(m, n));
    }
}