package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTest1 {

    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        Thread t = new Thread(new MyThread(),"时钟线程");
        t.start();
//        Thread.sleep(4000);
//        t.interrupt();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName()+"出现了异常");
        e.printStackTrace();
    }
}

class MyThread implements Runnable{

    //不在run方法中包异常 那怎么搞？？？？
    @Override
    public void run() {
        while (true) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException();
        }
    }
}
