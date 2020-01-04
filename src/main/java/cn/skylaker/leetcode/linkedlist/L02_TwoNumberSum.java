package cn.skylaker.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

/**
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class L02_TwoNumberSum {
    @Test
    public void test(){
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(8);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
        n2.next.next.next = new ListNode(9);

        ListNode newList = addTwoNumbersV1(n1, n2);
        printList(newList);
    }

    /**
     * 思路：直接从低到高依次相加
     *
     * 执行用时 :3 ms, 在所有 Java 提交中击败了43.92% 的用户
     * 内存消耗 :44.4 MB, 在所有 Java 提交中击败了85.97%的用户
     */
    public ListNode addTwoNumbersV1(ListNode l1, ListNode l2) {
        // 新链表哨兵节点
        ListNode newList = new ListNode(-1);
        ListNode tail = newList;

        ListNode p = l1;
        ListNode q = l2;
        // 每个节点进位
        int m = 0;

        // 依次遍历链表对应位相加，缓存进位到m
        while (null != p && null != q) {
            int val = p.val + q.val + m;
            ListNode node = new ListNode(val % 10);
            tail.next = node;
            tail = node;

            m = val / 10;

            p = p.next;
            q = q.next;
        }

        // 判断较长的那个链表
        ListNode k = null;
        if(null != p){
            k = p;
        }
        if(null != q){
            k = q;
        }

        // 将较长的那个剩余部分复制到新链表
        while (null != k){
            int val = m + k.val;
            ListNode node = new ListNode(val % 10);
            tail.next = node;
            tail = node;
            m = val / 10;

            k = k.next;
        }

        // 最后有可能进位
        if(m > 0){
            ListNode node = new ListNode(m);
            tail.next = node;
            tail = node;
        }

        return newList.next;
    }

    /**
     * 错误思路！！！！！ -----> 先获取数本身，相加，再转成对应链表
     */
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        if(0 == l1.val){
            return l2;
        }

        if(0 == l2.val){
            return l1;
        }

        ListNode p = l1;
        ListNode q = l2;

        int int1 = 0;
        int m = 1;
        while (null != l1){
            int1 += l1.val * m;
            m = m * 10;
            l1 = l1.next;
        }

        int int2 = 0;
        m = 1;
        while (null != l2){
            int2 += l2.val * m;
            m = m * 10;
            l2 = l2.next;
        }

        // 新链表哨兵节点
        ListNode newList = new ListNode(-1);
        ListNode tail = newList;

        // ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        // 错误点在这：因为 int 数相加可能溢出，但是采用链表方式按位处理，永远都是10以内加法不会出问题
        //！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        int val = int1 + int2;

        // 依次截取每位数字
        m = 10;
        while (val / (m / 10) != 0){
            ListNode node = new ListNode((val % m) / (m / 10));
            tail.next = node;
            tail = node;

            m = m * 10;
        }

        return newList.next;
    }

    public static void printList(ListNode l1){
        while (null != l1){
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}