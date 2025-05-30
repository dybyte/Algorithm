import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder solution(int m, int n) {
        StringBuilder sb = new StringBuilder("");
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean isDecimal = true;
            for (int tmp : list) {
                if (tmp * tmp > i) break;
                if (i % tmp == 0) {
                    isDecimal = false;
                    break;
                }
            }
            if (isDecimal) list.add(i);
        }
        for (int tmp : list) {
            if (tmp >= m) sb.append(tmp).append("\n");
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