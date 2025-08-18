class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    int size;

    Node head, tail; 

    public LRUCache(int capacity) {
        size = capacity;

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        // double linked list <- 여기에 있는 특정 node를 제거
        Node node = map.get(key);
        remove(node);
        // tail node 추가
        // tail.prev -> last node <tail> 
        insert(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        if(map.size() == size){
            //head node 제거
            remove(head.next);
        }
        
        //tail node 추가
        insert(new Node(key, value));
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    private void insert(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        map.put(node.key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */