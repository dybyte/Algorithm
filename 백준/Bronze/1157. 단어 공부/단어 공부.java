import java.io.*;
import java.util.*;

public class Main {
    public Character solution(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(Character.toUpperCase(chars[i]), map.getOrDefault(Character.toUpperCase(chars[i]), 0) + 1);
        }
        int max = 0;
        char answer = 0;
        for (char c : map.keySet()) {
            if (max < map.get(c)) {
                max = map.get(c);
                answer = c;
            }
        }
        int count = 0;
        for (char c : map.keySet()) {
            if (max == map.get(c)) count++;
        }
        if (count > 1) return '?';
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        System.out.println(T.solution(chars));
    }
}