package myconcurrent.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample1 {

    private final static int threadNum = 1000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            final int num = i;
            exec.execute(() -> {
                try {
                    doSomething(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        //阻塞当前线程，让之前启动的线程执行完后，才能走下去  countDownLatch.countDown() 为0了
        //countDownLatch.await();

        //给定时间进行阻塞，如果这个时间段内还没做完，那么就取消阻塞，让后面的继续下去，至于之前的线程有没有执行完，就不管了
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        System.out.println("finish..");
        exec.shutdown();
    }

    public static void doSomething(int i) throws InterruptedException {
        Thread.sleep(100);
        System.out.println(i);
    }

}
