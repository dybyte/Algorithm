import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder solution(int a, int b, int c, int d) {
        StringBuilder sb = new StringBuilder("");
        int answer1 = a * d + b * c;
        int answer2 = b * d;
        for (int i = Math.min(answer1, answer2); i >= 2; i--) {
            if (answer1 % i == 0 && answer2 % i == 0) {
                answer1 /= i;
                answer2 /= i;
                break;
            }
        }
        return sb.append(answer1).append(" ").append(answer2);
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