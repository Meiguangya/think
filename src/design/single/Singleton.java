package design.single;

/**
 * 登记式/静态内部类
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：一般
 */
public class Singleton {

    //private static Singleton instance;

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
        System.out.println("create...");
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
    }

}
