import java.io.*;
import java.util.*;

public class Main {
    public int solution(List<Integer> arr, List<Character> operator) {
        int answer = 0;
        int tmp = 0;
        int subIdx = operator.size() - 1;
        for (int i = arr.size() - 1; i >= 1; i--, subIdx--) {
            tmp += arr.get(i);
            if (operator.get(subIdx) == '-') {
                answer -= tmp;
                tmp = 0;
            }
        }
        answer += arr.get(0);
        if (tmp != 0) answer += tmp;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        List<Integer> arr1 = new ArrayList<>();
        List<Character> arr2 = new ArrayList<>();
        StringBuilder tmp = new StringBuilder("");
        for (char c : chars) {
            if (Character.isDigit(c)) tmp.append(c);
            else {
                if (tmp.length() != 0) {
                    arr1.add(Integer.parseInt(tmp.toString()));
                    tmp.delete(0, tmp.length() + 1);
                }
                arr2.add(c);
            }
        }
        arr1.add(Integer.parseInt(tmp.toString()));
        System.out.println(T.solution(arr1, arr2));
    }
}