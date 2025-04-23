import java.io.*;

public class Main {
    public String solution(int m, int n) {
        int answer = 0;
        int min = 0;
        for (int i = 1; i <= 100; i++) {
            int num = i * i;
            if (num >= m && num <= n) {
                answer += num;
                if (min == 0) min = num;
            }
        }
        if (answer == 0) return "-1";
        return answer + "\n" + min;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        System.out.println(T.solution(m, n));
    }
}