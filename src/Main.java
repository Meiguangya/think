import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        String a = "10";
        String b = a;
        a = "20";
        System.out.println(b);

        Comparable<String> comparable = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };

        Comparator<String> com = (s1,s2) -> s1.length() - s2.length();

        String[] arr = {"aa","bbb"};

        Arrays.sort(arr,(s1,s2) -> s1.length() - s2.length());


    }

}
