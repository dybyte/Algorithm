import java.io.*;
import java.util.*;

public class Main {


    public void solution(int[] arr, int[][] line, StringBuilder sb) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i + 1; j < arr.length; j++) list.add(arr[j]);
            map.put(arr[i], list);
        }
        for (int i = 0; i < line.length; i++) {
            int first = line[i][0];
            int second = line[i][1];

            List<Integer> list1 = map.get(first);
            List<Integer> list2 = map.get(second);
            if (list1.contains(second)) {
                list2.add(first);
                map.put(second, list2);
                for (int j = 0; j < list1.size(); j++) if (list1.get(j) == second) list1.remove(j);
            } else {
                list1.add(second);
                map.put(first, list1);
                for (int j = 0; j < list2.size(); j++) if (list2.get(j) == first) list2.remove(j);
            }
        }
        short[] visited = new short[arr.length + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] hasCycle = new boolean[]{false};
        for (int i = 0; i < arr.length; i++) {
            if (visited[arr[i]] == 2) continue;
            visited[arr[i]] = 1;
            dfs(map, visited, stack, arr[i], hasCycle);
            if (hasCycle[0]) {
                sb.append("IMPOSSIBLE").append("\n");
                return;
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        sb.append("\n");
    }

    private void dfs(Map<Integer, List<Integer>> map, short[] visited, Deque<Integer> stack, int i, boolean[] hasCycle) {
        for (int node : map.get(i)) {
            if (visited[node] == 0) {
                visited[node] = 1;
                dfs(map, visited, stack, node, hasCycle);
            } else if (visited[node] == 1) {
                hasCycle[0] = true;
            }
        }
        stack.push(i);
        visited[i] = 2;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int x = Integer.parseInt(br.readLine());
        for (int j = 0; j < x; j++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[][] line = new int[m][2];
            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(br.readLine());
                line[i][0] = Integer.parseInt(token.nextToken());
                line[i][1] = Integer.parseInt(token.nextToken());
            }
            T.solution(arr, line, sb);
        }
        System.out.println(sb);
    }
}