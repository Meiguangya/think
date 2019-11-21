package thread;

import java.util.HashMap;
import java.util.Map;

public class MultiThreadErrorTest {

    private Map<String,String> store;

    MultiThreadErrorTest(){
        store = new HashMap<>();
        store.put("1","a");
        store.put("2","b");
        store.put("3","c");
    }

    public Map<String,String> getStore(){
        return store;
    }

    public Map<String,String> getStoreImporve(){
        return new HashMap<>(store);
    }

    public static void main(String[] args) {
        MultiThreadErrorTest mt = new MultiThreadErrorTest();
        Map<String,String> map = mt.getStoreImporve();
        System.out.println(map.get("1"));
        System.out.println(map.remove("1"));
        System.out.println(map.get("1"));

        System.out.println(mt.getStoreImporve().get("1"));
        System.out.println(mt.getStoreImporve().remove("1"));
        System.out.println(mt.getStoreImporve().get("1"));

    }

}
