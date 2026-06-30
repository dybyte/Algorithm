class LRUCache {

    Map<Integer, Node> map = new HashMap<>();  //key, value node
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //head: recent node
        //tail: old node
        head = new Node(null, null, -1, -1);
        tail = new Node(head, null, -1, -1);
        head.next = tail;
    }
    
    public int get(int key) {
        Node target = map.get(key);
        if(target == null) return -1;

        remove(target);
        addFirst(target);
        
        return target.value;
    }
    
    public void put(int key, int value) {
        Node target;
        if(map.containsKey(key)){
            target = map.get(key);
            target.value = value;
            remove(target);
            addFirst(target);
        } else {
            if(map.size() == capacity){
                Node removed = tail.prev;
                remove(removed);
                map.remove(removed.key);
            }
            target = new Node(null, null, key, value);
            addFirst(target);
        }
        map.put(key, target);
    }

    private void remove(Node target){
        target.prev.next = target.next;
        target.next.prev = target.prev;
    }

    private void addFirst(Node target){
        target.prev = head;
        target.next = head.next;
        head.next.prev = target;
        head.next = target;
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(Node prev, Node next, int key, int value) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */