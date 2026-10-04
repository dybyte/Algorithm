class MyLinkedList {
    class Node {
        Node prev;
        Node next;
        int val;

        Node(Node prev, Node next, int val){
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = new Node(null, null, -1);
        tail = new Node(head, null, -1);
        head.next = tail;
    }
    
    public int get(int index) {
        return getNode(index).val;
    }

    private Node getNode(int index) {
        if(index < 0) return new Node(null, null, -1);
        int i = 0;

        Node target = head;
        if(head.val == -1) i = -1;

        while(i < index){
            target = target.next;
            if(target == null) return new Node(null, null, -1);
            if(target.val != -1) i++;
        }

        return target;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(null, null, val);
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(null, null, val);
        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        Node node = new Node(null, null, val);
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index == size) {
            addAtTail(val);
            return;
        }


        Node next = getNode(index);
        if(next.val == -1) return;

        Node prev = next.prev;

        prev.next = node;
        next.prev = node;
        
        node.prev = prev;
        node.next = next;

        size++;
    }
    
    public void deleteAtIndex(int index) {
        Node node = getNode(index);
        if(node.val == -1) return;

        if(node.prev == null){//head
            Node next = node.next;
            node.next = null;
            next.prev = null;
            head = next;
            size--;
            return;
        }

        if(node.next == null){//tail
            Node prev = node.prev;
            node.prev = null;
            prev.next = null;
            tail = prev;
            size--;
            return;
        }

        Node prev = node.prev;
        Node next = node.next;

        node.next = null;
        node.prev = null;

        prev.next = next;
        next.prev = prev;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */