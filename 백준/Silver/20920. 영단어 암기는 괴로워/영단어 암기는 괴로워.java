import java.io.*;
import java.util.*;

public class Main {
    public StringBuilder solution(String[] arr, int m) {
        StringBuilder sb = new StringBuilder("");
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            if (s.length() < m) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Word> words = new PriorityQueue<>(Word::compareTo);
        for (String s : map.keySet()) {
            words.add(new Word(s, map.get(s)));
        }
        while (!words.isEmpty()) {
            sb.append(words.poll().word).append("\n");
        }
        return sb;
    }

    class Word implements Comparable<Word> {
        String word;
        int value;

        public Word(String word, int value) {
            this.word = word;
            this.value = value;
        }

        @Override
        public int compareTo(Word o) {
            if (this.value == o.value) {
                if (this.word.length() == o.word.length()) {
                    return this.word.compareTo(o.word);
                }
                return o.word.length() - this.word.length();
            }
            return o.value - this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        System.out.println(T.solution(arr, m));
    }
}