import java.util.*;

public class Solution5197 {

    /**
     * 给你个整数数组 arr，其中每个元素都 不相同。
     * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
     */

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = new Double(Math.pow(10, 6) * 2).intValue();
        List list = Arrays.asList(arr);
        Collections.sort(list);
        List<Integer> temp = new ArrayList();
        list.forEach(item -> {
            temp.add((Integer) item);
        });

        int left = 0, right = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); i++) {
                int num = Math.abs(temp.get(i) - temp.get(j));
                if (num < min) {
                    left = temp.get(i);
                    right = temp.get(j);
                    res.clear();
                }else{

                }
            }
        }
        return null;
    }


    public static void main(String[] args) {

    }
}
