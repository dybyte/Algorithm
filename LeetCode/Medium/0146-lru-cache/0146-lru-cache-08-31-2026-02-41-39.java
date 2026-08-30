class LRUCache {
    class Node {
        Node left;
        int key;
        int val;
        Node right;

        Node(Node left, int key, int val, Node right){
            this.left = left;
            this.key = key;
            this.val = val;
            this.right = right;
        }

        Node(){
            this.key = -1;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.right = tail;
        tail.left = head;
        //head -- tail
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node.left, node.right, node);
            //맨 앞에 붙임
            // head -- ?
            // head -- node -- ?
            Node tmp = head.right;
            head.right = node;
            node.left = head;
            node.right = tmp;
            tmp.left = node;

            return node.val;
        }
        return -1;
    }

    void remove(Node left, Node right, Node remove){
        left.right = right;
        right.left = left;
        remove.left = null;
        remove.right = null;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;

            remove(node.left, node.right, node);
            //맨 앞에 붙임
            // head -- node -- ?
            Node tmp = head.right;
            head.right = node;
            node.left = head;
            node.right = tmp;
            tmp.left = node;
            
            map.put(key, node);
            return;
        }
        if(map.size() >= capacity){
            //tail에 연결된 노드를 버린다.
            //linkedlist, map 모두에서 제거
            Node node = tail.left;
            //? -- node -- tail
            //? -- tail
            remove(node.left, tail, node);

            map.remove(node.key);
        }
        Node node = new Node(null, key, value, null);
        //head에 연결
        Node tmp = head.right;
        head.right = node;
        node.left = head;
        node.right = tmp;
        tmp.left = node;

        map.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */