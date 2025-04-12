import java.io.*;
import java.util.*;

public class Main {
    public StringBuilder solution(int a, int b) {
        StringBuilder sb = new StringBuilder("");
        int pow = (int) Math.pow(Math.pow(a, 2) - b, 0.5);
        int n1 = -a + pow;
        int n2 = -a - pow;
        if (n1 == n2) return sb.append(n1);
        else return sb.append(Math.min(n1, n2)).append(" ").append(Math.max(n1, n1));

    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        System.out.println(T.solution(n, m));
    }
}