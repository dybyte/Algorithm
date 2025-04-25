import java.io.*;
public class Main {
    public StringBuilder solution(long[] arr) {
        long pow = (long) Math.pow(10, 6);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            boolean mod = true;
            for (int j = 2; j < pow; j++) {
                if (arr[i] % j == 0) {
                    sb.append("NO").append("\n");
                    mod = false;
                    break;
                }
            }
            if (mod) sb.append("YES").append("\n");
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        System.out.println(T.solution(arr));
    }
}