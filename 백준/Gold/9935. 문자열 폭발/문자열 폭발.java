import java.io.*;
import java.util.*;

public class Main {
    public String solution(char[] arr, char[] bomb) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            for (int j = bomb.length - 1; j >= 0; j--) {
                if (!stack.isEmpty() && stack.peek() == bomb[j]) {
                    stack.pop();
                } else {
                    for (int k = j + 1; k < bomb.length; k++) {
                        stack.push(bomb[k]);
                    }
                    break;
                }
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        if (sb.length() == 0) return "FRULA";
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        System.out.println(T.solution(arr, bomb));
    }
}