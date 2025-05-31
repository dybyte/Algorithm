import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder solution(int a, int b, int c, int d) {
        StringBuilder sb = new StringBuilder("");
        int answer1 = a * d + b * c;
        int answer2 = b * d;
        int gcd = gcd(answer1, answer2);
        return sb.append(answer1/gcd).append(" ").append(answer2/gcd);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());
        System.out.println(solution(a, b, c, d));
    }
}