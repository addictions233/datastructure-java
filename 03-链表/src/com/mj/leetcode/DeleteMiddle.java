package com.mj.leetcode;

/**
 * @description: 2095. 删除链表的中间节点
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 * @author: wanjunjie
 * @date: 2025/01/06
 */
public class DeleteMiddle {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return new ListNode();
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = slow;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = slow.next;
        return head;
    }
}
