class LRUCache {
    int max;
    Map<Integer, Integer> map = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();


    public LRUCache(int capacity) {
        max =  capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        queue.remove(new Integer(key));
        queue.offer(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) queue.remove(new Integer(key));
        if(queue.size() == max){
            int poll = queue.poll();
            map.remove(poll);
        }
        queue.offer(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */