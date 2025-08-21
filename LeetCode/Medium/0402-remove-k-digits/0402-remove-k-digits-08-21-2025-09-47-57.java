class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = num.toCharArray();
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        StringBuilder ans = new StringBuilder("");
        while(!stack.isEmpty()){
            if(stack.peekLast() != '0') break;
            stack.pollLast();
        }
        while(!stack.isEmpty()){
            if(k > 0){
                stack.pollLast();
                k--;
                continue;
            }
            ans.append(stack.pollLast());
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}