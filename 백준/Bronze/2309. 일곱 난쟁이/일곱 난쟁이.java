import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public List<Integer> solution(List<Integer> list) {
        int max = 0;
        for (int i : list) {
            max += i;
        }
        max -= 100;
        int one = -1, two = -1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == max) {
                    one = i;
                    two = j;
                    break;
                }
            }
            if (one != -1) {
                break;
            }
        }
        list.remove(one);
        list.remove(two - 1);
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> solution = main.solution(list);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}