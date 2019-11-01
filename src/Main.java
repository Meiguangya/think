import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(list.hashCode());
        foo(list);
        //list = list1;
        System.out.println(list.hashCode());

        System.out.println(list);

    }


    public static void foo(List<Integer> list){

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                list1.add(list.get(i));
            }
        }

        list = list1;
        System.out.println(list.hashCode());
        list.add(10);

    }
}
