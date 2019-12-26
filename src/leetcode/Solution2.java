package leetcode;

import java.math.BigInteger;
import java.util.List;

public class Solution2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = "";
        while (l1 != null) {
            s1 += l1.val;
            l1 = l1.next;
        }
        String s2 = "";
        while (l2 != null) {
            s2 += l2.val;
            l2 = l2.next;
        }
        BigInteger n1 = new BigInteger(new StringBuffer(s1).reverse().toString());
        BigInteger n2 = new BigInteger(new StringBuffer(s2).reverse().toString());

        BigInteger n3 = n1.add(n2);

        String res = new StringBuffer(String.valueOf(n3)).reverse().toString();
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i = 0; i < res.length(); i++) {
            ListNode node = new ListNode(Integer.parseInt(String.valueOf(res.charAt(i))));
            head.next = node;
            head = head.next;
        }

        return dummy.next;
    }


    //(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //[9]
    //[1,9,9,9,9,9,9,9,9,9]
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(9);
        ListNode node2 = new ListNode(7);
        node2.next = new ListNode(8);
        addTwoNumbers(node1,node2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
