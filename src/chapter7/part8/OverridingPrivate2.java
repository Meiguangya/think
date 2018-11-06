package chapter7.part8;

class WithFinals {
    private final void f() {
        System.out.println("WithFinals.f()");
    }

    private void g() {
        System.out.println("WithFinal.g()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}

/**
 * 测试final方法
 * 类中的private方法都是隐式带有final的
 * 如果试图覆盖一个private方法似乎是奏效的，但....
 */
public class OverridingPrivate2 extends OverridingPrivate {
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    private void g() {
        System.out.println("OverridingPrivate.g()");
    }

    public static void main(String[] args) {
        OverridingPrivate2 o2 = new OverridingPrivate2();
        o2.f();
        o2.g();
        //OverridingPrivate.f()
        //OverridingPrivate.g()

        //向上转型
        OverridingPrivate op = o2;
        //op.f();
        //op.g();
        //can't use the methods

        //upcase
        WithFinals wf = o2;
        //wf.f();
        //wf.g();
        //can't use the methods

        /**
         * 使用private修饰的方法无法被触及且隐藏，子类中的同名方法并没有覆盖该方法
         * 是生成了一个新的方法
         *
         **/
    }

}
