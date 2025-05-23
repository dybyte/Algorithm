import java.io.*;
import java.util.*;

public class Main {
    public static int solution(Set<Integer> set, int m) {
        if (set.contains(m)) return 1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(token.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(solution(set, Integer.parseInt(token.nextToken()))).append("\n");
        }
        System.out.println(sb);
    }
}