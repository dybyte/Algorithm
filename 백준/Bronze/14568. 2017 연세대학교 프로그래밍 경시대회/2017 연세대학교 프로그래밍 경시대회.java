import java.io.*;

public class Main {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i += 2) {
            for (int j = 1; i + j <= n; j++) {
                if (j + 2 <= n - i - j) answer++;
                else break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(T.solution(n));
    }
}