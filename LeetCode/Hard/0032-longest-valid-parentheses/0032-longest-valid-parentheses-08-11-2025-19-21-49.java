class Solution {
    public int longestValidParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int maxLen = 0;
        for(int i = 0; i < s.length() - 1; i++){
            stack.clear();
            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == '('){
                    stack.push('(');
                } else {
                    if(stack.isEmpty()) break;
                    stack.pop();
                }
                if(stack.isEmpty()) maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}