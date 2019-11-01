package niu0822;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * @author meiguangya
 * map 的遍历
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "world");

//        method1(map);
//
        method2(map);
//
//        method3(map);

        //method4(map);

    }

    /**
     * 使用Map.Entry
     *
     * @param map
     */
    public static void method1(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + " val:" + entry.getValue());
        }
    }

    public static void method2(Map<Integer, String> map) {
        for (Integer integer : map.keySet()) {
            System.out.println("key:" + integer + " val:" + map.get(integer));
        }
        map.values().forEach(s -> System.out.println(s));
    }

    public static void method3(Map<Integer, String> map) {
        map.forEach((key, val) -> {
            System.out.println("key:" + key + " val:" + val);
        });
    }

    public static void method4(Map<Integer, String> map) {
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + " val:" + entry.getValue());
        }
    }

}
