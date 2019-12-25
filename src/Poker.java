import java.util.*;

/**
 * 牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
 * 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。
 * 他们的得分等于他们抽到的纸牌数字总和。
 * 现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 * <p>
 * <p>
 * 输入描述:
 * 输入包括两行。
 * 第一行包括一个正整数n(1 <= n <= 105),表示纸牌的数量。
 * 第二行包括n个正整数ai(1 <= ai <= 109),表示每张纸牌上的数字。
 * <p>
 * 输出描述:
 * 输出一个整数, 表示游戏结束后牛牛得分减去羊羊得分等于多少。
 */
public class Poker {

    public static void main(String[] args) {

//        System.out.println("输入纸牌数量:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
//        System.out.println("输入纸牌的数字");
        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {
            if (list.size() == size - 1) {
                list.add(sc.nextInt());
                break;
            } else {
                list.add(sc.nextInt());
            }
        }
        sc.close();

        list.sort((a, b) -> {
            return b - a;
        });

        List<Integer> niu = new ArrayList<>();
        List<Integer> yang = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            niu.add(list.get(i));
            if (++i < list.size()) {
                yang.add(list.get(i));
            }
        }
        int niuNum = getSum(niu);
        int yangNum = getSum(yang);

        System.out.println(niuNum - yangNum);

    }

    static int getSum(List<Integer> list) {
        int i = 0;
        for (Integer item : list) {
            i += item;
        }
        return i;
    }


}
