class Solution {
    static {
        for(int i = 0; i < 100000; i++) System.out.println(Math.random());
    }
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : num.toCharArray()){
            while(!stack.isEmpty() && stack.peek() > c && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // Example 1
        // num = "1432219" k = 5
        // num = "119"
        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()){
            if(stack.peekLast() != '0') break;
            stack.pollLast();
        }
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }

        return sb.length() == 0 ? "0" : sb.toString();

    }
}