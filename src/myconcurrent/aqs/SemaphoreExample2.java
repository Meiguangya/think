package myconcurrent.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample2 {

    private final static int threadNums = 100;
    private final static int concurrentNum = 12;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(concurrentNum);
        for (int i = 0; i < threadNums; i++) {
            final int n = i;
            exec.execute(() -> {
                try {
                    //每次拿3个  总数12个 这样就4个线程一起执行
                    boolean hasDo = false;
                    System.out.println(hasDo);
                    while (!hasDo) {
                        semaphore.acquire(3);
                        hasDo = true;
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
