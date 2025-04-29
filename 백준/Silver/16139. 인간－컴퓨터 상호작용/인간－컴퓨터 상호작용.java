import java.io.*;
import java.util.*;

public class Main {
    public StringBuilder solution(char[] chars, char[] arr1, int[][] arr2) {
        StringBuilder sb = new StringBuilder("");
        Map<Character, int[]> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int[] arr = new int[chars.length + 1];
            int idx = 1;
            for (int i = 0; i < chars.length; i++) {
                int tmp = chars[i] == c ? 1 : 0;
                arr[idx] = arr[idx++ - 1] + tmp;
            }
            map.put(c, arr);
        }
        for (int i = 0; i < arr1.length; i++) {
            int[] arr = map.get(arr1[i]);
            sb.append(arr[arr2[i][1] + 1] - arr[arr2[i][0]]).append("\n");
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        char[] arr1 = new char[n];
        int[][] arr2 = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            arr1[i] = token.nextToken().charAt(0);
            arr2[i][0] = Integer.parseInt(token.nextToken());
            arr2[i][1] = Integer.parseInt(token.nextToken());
        }
        System.out.println(T.solution(chars, arr1, arr2));
    }
}