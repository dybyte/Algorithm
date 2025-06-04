class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        boolean[] visited = new boolean[n*2];
        backTracking(visited, 0, new StringBuilder(""), 0, 0, n*2);
        return answer;
    }

    void backTracking(boolean[] visited, int cur, StringBuilder sb, int open, int close, int n){
        if(sb.length() == n) {
            answer.add(sb.toString());
            return;
        }
        if(open > close) {
            visited[cur] = true;
            sb.append(')');
            backTracking(visited, cur+1, sb, open, close + 1, n);
            sb.deleteCharAt(cur);
            visited[cur] = false;
        }
        if(open < n/2){
            visited[cur] = true;
            sb.append('(');
            backTracking(visited, cur+1, sb, open + 1, close, n);
            sb.deleteCharAt(cur);
            visited[cur] = false;
        }
    }
}