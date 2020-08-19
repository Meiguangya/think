package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Demo1 {

    public static void main(String[] args) {
        String s = "100";
        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s+"--c1");
            }
        };
        c1.accept(s);

        Consumer<Integer> c2 = (Integer i)->{
            System.out.println(i+s);
        };
        c2.accept(200);

        Consumer<String> c3 = System.out::println;
        c3.accept("gg");

        Consumer<Integer> c4 = integer -> integer.toString();

        List<String> l = new ArrayList<>();
        l.forEach(System.out::println);

    }

}
