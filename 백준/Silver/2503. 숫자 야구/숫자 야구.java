import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] arr, int n) {
        int answer = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) continue;
                for (int k = 1; k < 10; k++) {
                    if (i == k || j == k) continue;
                    boolean isT = true;
                    for (int l = 0; l < n; l++) {
                        StringBuilder sb = new StringBuilder("");
                        if (!check(arr[l], sb.append(i).append(j).append(k).toString())) {
                            isT = false;
                            break;
                        }
                    }
                    if (isT) answer++;
                }
            }
        }
        return answer;
    }

    boolean check(int[] arr, String num) {
        String s = String.valueOf(arr[0]);
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < s.length(); i++) {
            if (num.contains(String.valueOf(s.charAt(i)))) {
                if (num.charAt(i) == s.charAt(i)) strike++;
                else ball++;
            }
        }
        if (strike == arr[1] && ball == arr[2]) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        System.out.println(T.solution(arr, n));
    }
}