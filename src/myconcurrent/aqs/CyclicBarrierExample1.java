package myconcurrent.aqs;

import java.util.concurrent.*;

public class CyclicBarrierExample1 {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            final int n = i;
            exec.execute(() -> {
                boolean f = false;
                while (!f) {
                    try {
                        semaphore.acquire(1);
                        doSomething(n);
                        f = true;
                        semaphore.release(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        exec.shutdown();
    }

    public static void doSomething(int i) {
        try {
            Thread.sleep(1000);
            System.out.println("线程" + i + "已经准备就绪");
            barrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + i + "开始执行");
    }

}
