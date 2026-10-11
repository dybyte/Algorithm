class MyCircularQueue {
    int size;
    int capacity;
    int front;
    int rear;

    int[] arr;

    public MyCircularQueue(int k) {
        capacity = k;
        arr = new int[capacity];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
        arr[rear] = value;
        rear = (rear + capacity - 1) % capacity;
        size++;

        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        front = (front + capacity - 1) % capacity;
        size--;

        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;

        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return arr[(rear + 1) % capacity];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */