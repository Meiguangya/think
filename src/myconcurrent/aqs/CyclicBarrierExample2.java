package myconcurrent.aqs;

import java.util.concurrent.*;

public class CyclicBarrierExample2 {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    private static CyclicBarrier barrier = new CyclicBarrier(5,()->{
        System.out.println("线程数到达指定数量，屏障开启");
    });

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
            Thread.sleep(2000);
            System.out.println("线程" + i + "已经准备就绪");
            //传入等待时间 如果超过这个时间
            barrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (BrokenBarrierException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + i + "开始执行");
    }

}
