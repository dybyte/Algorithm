import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] arr, int n) {
        int mod = n;
        for (int i = 0; i < arr.length; i++) {
            mod %= arr[i];
            if (mod == 0) return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());
        System.out.println(T.solution(new int[]{c, b, a}, n));
    }
}