class FooBar {
    private final Lock lock = new ReentrantLock();
    private final Condition conditionFoo = lock.newCondition();
    private final Condition conditionBar = lock.newCondition();

    private volatile boolean isFooTurn = true;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while(!isFooTurn){
                    conditionFoo.await();
                }

                // printFoo.run() outputs "foo". Do not change or remove this line.
        	    printFoo.run();

                isFooTurn = false;
                conditionBar.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while(isFooTurn){
                    conditionBar.await();
                }

                // printBar.run() outputs "bar". Do not change or remove this line.
        	    printBar.run();

                isFooTurn = true;
                conditionFoo.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}