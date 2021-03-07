package myconcurrent.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample3 {

    private final static int threadNums = 100;
    private final static int concurrentNum = 12;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(concurrentNum);
        for (int i = 0; i < threadNums; i++) {
            final int n = i;
            exec.execute(() -> {
                try {
                    //尝试在1秒内去拿3个 如果拿不到 就进不到if里面去，这个线程也就被抛弃了
                    if(semaphore.tryAcquire(3,2, TimeUnit.SECONDS)){
                        doSomething(n);
                        semaphore.release(3);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        exec.shutdown();

    }

    public static void doSomething(int i) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(i);
    }

}
