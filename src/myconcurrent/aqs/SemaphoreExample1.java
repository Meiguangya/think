package myconcurrent.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {

    private final static int threadNums = 1000;
    private final static int concurrentNum = 20;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(concurrentNum);
        for (int i = 0; i < threadNums; i++) {
            final int n = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    doSomething(n);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        exec.shutdown();

    }

    public static void doSomething(int i) throws InterruptedException {
        Thread.sleep(100);
        System.out.println(i);
    }

}
