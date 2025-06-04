class Solution {
    List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder("");
        backTracking(sb, 0, 0, 2*n);
        return answer;
    }

    void backTracking(StringBuilder sb, int open, int close, int n){
        if(sb.length() == n){
            answer.add(sb.toString());
            return;
        }

        if(open > close){
            sb.append(")");
            backTracking(sb,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(open < n/2){
            sb.append("(");
            backTracking(sb,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}