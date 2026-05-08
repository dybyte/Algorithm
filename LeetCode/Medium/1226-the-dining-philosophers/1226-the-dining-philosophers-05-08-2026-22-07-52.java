import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    private final ReentrantLock lock = new ReentrantLock();

    public DiningPhilosophers() {
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        lock.lock();
        try {
            pickLeftFork.run();
            pickRightFork.run();

            eat.run();

            putLeftFork.run();
            putRightFork.run();
        } finally {
            lock.unlock();
        }
    }
}