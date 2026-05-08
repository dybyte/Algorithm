class DiningPhilosophers {
    ReentrantLock[] forks;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = philosopher == 4 ? 0 : philosopher + 1;

        while(true){
            if(forks[left].tryLock()){
            try {
                if(forks[right].tryLock()){
                    try {
                       pickLeftFork.run();
                       pickRightFork.run();
                       eat.run();
                       putLeftFork.run();
                       putRightFork.run();
                       return;
                    } finally {
                        forks[right].unlock();
                    }
                }
            } finally {
                forks[left].unlock();
            }
            
        }
        Thread.sleep(1);
        }

                            
        
    }
}