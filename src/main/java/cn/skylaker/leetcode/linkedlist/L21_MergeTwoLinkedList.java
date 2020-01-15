package cn.skylaker.leetcode.linkedlist;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class L21_MergeTwoLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode newLinkedList = mergeTwoLists(l1, l2);
        ListNode p = newLinkedList;
        while (p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(-1);
        ListNode p = newNode, tail = newNode;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val){
                tail.next = p1;
                p1 = p1.next;

            } else {
                tail.next = p2;
                p2 = p2.next;
            }

            tail = tail.next;
        }

        if(p1 != null){
            while(p1 != null){
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;
            }
        }

        if(p2 != null){
            while(p2 != null){
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
            }
        }

        return p.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
