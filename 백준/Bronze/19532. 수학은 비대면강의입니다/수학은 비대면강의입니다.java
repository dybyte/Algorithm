import java.io.*;
import java.util.*;

public class Main {
    public String solution(int[] arr) {
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (arr[0] * x + arr[1] * y == arr[2] && arr[3] * x + arr[4] * y == arr[5]) return x + " " + y;
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(arr));
    }
}