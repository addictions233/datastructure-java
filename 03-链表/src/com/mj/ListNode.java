package com.mj;

/**
 * @description: leetcode中的链表类
 * @author: wanjunjie
 * @date: 2025/01/03
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
