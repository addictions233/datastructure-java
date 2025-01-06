package com.mj.leetcode;

import org.junit.Test;

/**
 * @description: 148. 排序链表   给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @author: wanjunjie
 * @date: 2025/01/03
 */
public class SortList {

    /**
     * 使用分治的思想
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = middle(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = slow;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return previous;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode result = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }

        if (right != null) {
            head.next = right;
        }

        if (left != null) {
            head.next = left;
        }

        return result.next;
    }


    @Test
    public void test() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        sortList(head);
    }
}
