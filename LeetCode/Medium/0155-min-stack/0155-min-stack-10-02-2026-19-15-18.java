class MinStack {
    class Node {
        int val;
        int min;
        Node left;

        Node(int val, int min, Node left){
            this.val = val;
            this.min = min;
            this.left = left;
        }
    }
    Node top;

    public MinStack() {
        
    }
    
    public void push(int value) {
        int min = top == null ? Integer.MAX_VALUE : top.min;
        Node node = new Node(value, Math.min(min, value), top);
        top = node;
    }
    
    public void pop() {
        Node left = top.left;
        top.left = null;
        top = left;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */