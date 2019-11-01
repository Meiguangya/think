import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2 {

    public int[] fraction(int[] cont) {
        return getNum(cont, 0);
    }

    public int[] getNum(int[] cont, int l) {
        if (l == cont.length - 2) {
            int[] temp = new int[]{cont[l] * cont[l + 1] + 1, cont[l + 1]};
            return temp;
        }
        return formatNum(cont[l], getNum(cont, l + 1));
    }

    public int[] formatNum(int num, int[] arr) {
        int[] res = new int[2];
        res[0] = 1 * arr[1] + num * arr[0];
        res[1] = arr[0];
        return res;
    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        int[] res = s.fraction(new int[]{3, 2, 0, 2});
        int[] res = s.fraction(new int[]{0,1,2});

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i] + " ");
        }
    }

}
