import java.io.*;
import java.math.*;

public class Main {
    public BigDecimal solution(int n) {
        BigDecimal count1 = new BigDecimal(1);
        BigDecimal count2 = new BigDecimal(1);
        for (int i = 2; i <= n; i++) {
            BigDecimal count = count1.multiply(BigDecimal.valueOf(2)).add(count2);
            count1 = count2;
            count2 = count;
        }
        return count2;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            sb.append(T.solution(Integer.parseInt(line))).append("\n");
        }
        System.out.println(sb);
    }
}