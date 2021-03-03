package huaweijishi.word;


import java.util.ArrayList;
import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = scanner.nextInt();
        ArrayList<Integer[]> resArr = new ArrayList<>(num);
        scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine().trim();
            if ("".equals(text)) {
                break;
            }
            String[] temp = text.split(" ");
            Integer[] intArr = new Integer[temp.length];
            for (int i = 0; i < temp.length; i++) {
                intArr[i] = Integer.valueOf(temp[i]);
            }
            resArr.add(intArr);
        }

        ArrayList<Integer> indexArr = new ArrayList<>();
        getMinIndex(resArr, indexArr);
        int count = 0;
        for (int j = 0; j < indexArr.size(); j++) {
            count += resArr.get(j)[indexArr.get(j)];
        }
        System.out.println(count);
    }

    public static void getMinIndex(ArrayList<Integer[]> resList, ArrayList<Integer> indexArr) {
        if (indexArr.size() == resList.size()) {
            return;
        }
        if (indexArr.size() == 0) {
            indexArr.add(minIndex(resList.get(0), -1));
        } else {
            indexArr.add(minIndex(resList.get(resList.size()), indexArr.get(indexArr.size() - 1)));
        }
        getMinIndex(resList, indexArr);
    }

    public static int minIndex(Integer[] resArr, int except) {
        int temp = resArr[0];
        int index = 0;
        for (int i = 0; i < resArr.length; i++) {
            if (except == i) {
                continue;
            }
            if (temp <= resArr[i]) {
                index = i;
                temp = resArr[i];
            }
        }
        return index;
    }

}
