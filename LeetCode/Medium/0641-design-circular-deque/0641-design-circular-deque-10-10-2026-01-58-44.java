class MyCircularDeque {
    int size;
    int capacity;

    int[] arr;
    int front;
    int rear;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.arr = new int[capacity];
    }
    
    public boolean insertFront(int value) {
        if(size == capacity) return false;

        arr[front] = value;
        this.front = (this.front + this.capacity - 1) % this.capacity;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == capacity) return false;

        this.rear = (this.rear + 1) % this.capacity;
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;

        this.front = (this.front + 1) % this.capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) return false;

        this.rear = (this.rear + this.capacity - 1) % this.capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        if(size == 0) return -1;
        return arr[(this.front + 1) % this.capacity];
    }
    
    public int getRear() {
        if(size == 0) return -1;
        return arr[this.rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */