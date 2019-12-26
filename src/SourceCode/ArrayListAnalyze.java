package SourceCode;

import java.util.ArrayList;

public class ArrayListAnalyze {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println(list1.size());
        list1.add("hello1");
        list1.add("hello2");

        list1.add("hello3");

        list1.add("hello4");

        list1.add("hello5");

        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i)=="hello3") list1.remove(i);
            System.out.println(list1.get(i));
        }

        System.out.println(list1.size());
        //System.out.println(list1.remove(0));


        ArrayList<Integer> list2 = new ArrayList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        for (int i = 0; i < list2.size(); i++) {
            if(list2.get(i)==3) list2.remove(i);
            System.out.println(list2.get(i));
        }
        System.out.println(list2.size());

//        ArrayList<String> list3 = new ArrayList<>(5);
//        System.out.println(list3.size());
//        list3.forEach(item-> System.out.println(item));
//        int[] a1 = new int[]{1,2,3,4,5};
//        int[] a2 = new int[]{11,12,13};
//        System.arraycopy(a1,0,a2,1,2);
//        for (int i = 0; i < a2.length; i++) {
//            System.out.println(a2[i]);
//        }
    }

}
