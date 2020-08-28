package leetcode;

import java.util.HashMap;

/**
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * <p>
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * <p>
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 * <p>
 * 输入: "UD"
 * 输出: true
 * <p>
 * 输入: "LL"
 * 输出: false
 */
public class Solution657 {

    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        int len = 0;
        String[] arr = moves.split("");
        while (len < moves.length()) {
            String s = arr[len];
            if ("R".equals(s)) {
                x++;
            } else if ("L".equals(s)) {
                x--;
            } else if ("U".equals(s)) {
                y++;
            } else if ("D".equals(s)) {
                y--;
            }
            len++;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
    }

}
