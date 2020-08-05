package thread;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer {
    static final int MAX_SIZE = 10;
    // 注意，这里使用并发安全的队列不是必需的，这里只是为了展示如何使用wait/notify实现生产消费模型
    static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

    public static void main(String[] args) {

        // 消费线程
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (queue) {
                            while (queue.size() == 0) {
                                try { // 挂起当前线程，并释放通过同步块获取的queue上面的锁，让生产线程可以获取该锁，生产元素放入队列
                                    queue.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            // 从队列拿出元素，并通知阻塞的生产线程
                            System.out.println(Thread.currentThread().getName() + " take ele " + queue.take());
                            queue.notifyAll();
                        }

                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "consumer-thread").start();

        // 生产线程
        new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    while (true) {
                        synchronized (queue) {
                            while (queue.size() == MAX_SIZE) {
                                try { // 挂起当前线程，并释放通过同步块获取的queue上面的锁，让消费线程可以获取该锁，然后获取队列里面元素
                                    queue.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            // 空闲则添加元素，并通知阻塞的消费线程
                            int ele = new Random().nextInt(100);
                            queue.add(ele + "");
                            System.out.println(Thread.currentThread().getName() + " add " + ele);
                            queue.notifyAll();

                        }

                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "producer-thread").start();
    }

}
