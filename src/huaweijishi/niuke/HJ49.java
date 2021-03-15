package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HJ49 {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = reader.readLine()) != null) {
            if(input.isEmpty()){
                break;
            }
            int n = Integer.valueOf(input);
            CountDownLatch countDownLatch =  new CountDownLatch(4*n);
            AtomicInteger atomicInteger = new AtomicInteger(1);
            StringBuffer sb = new StringBuffer("");
            Thread threadA = new Thread(new Mythread("A",sb,1,atomicInteger,4,n,countDownLatch));
            Thread threadB = new Thread(new Mythread("B",sb,2,atomicInteger,4,n,countDownLatch));
            Thread threadC = new Thread(new Mythread("C",sb,3,atomicInteger,4,n,countDownLatch));
            Thread threadD = new Thread(new Mythread("D",sb,0,atomicInteger,4,n,countDownLatch));
            threadA.start();
            threadB.start();
            threadC.start();
            threadD.start();
            countDownLatch.await();
            System.out.println(sb.toString());
        }
    }


    private static class Mythread implements Runnable {
        private String str;
        private StringBuffer strBuffer;
        private int orderBy;
        private AtomicInteger count;
        private int loopSize;
        private int num;
        private CountDownLatch countDownLatch;

        public Mythread(String str, StringBuffer strBuffer, int orderBy, AtomicInteger count,
                        int loopSize, int num, CountDownLatch countDownLatch) {
            this.str = str;
            this.strBuffer = strBuffer;
            this.orderBy = orderBy;
            this.count = count;
            this.loopSize = loopSize;
            this.num = num;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            //final int n = num / loopSize;
            synchronized (count) {
                for (int i = 0; i < num; i++) {
                    while (count.get() % loopSize != orderBy) {
                        try {
                            count.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    strBuffer.append(str);
                    count.addAndGet(1);
                    countDownLatch.countDown();
                    count.notifyAll();
                }
            }
        }

    }


}
