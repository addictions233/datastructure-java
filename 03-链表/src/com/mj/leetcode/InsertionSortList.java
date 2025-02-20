package com.mj.leetcode;

/**
 * @description: 147. 对链表进行插入排序
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * @author: wanjunjie
 * @date: 2025/02/19
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head.next;
        while(cur != null) {
            ListNode comp = head;
            do {
                if (cur.val < comp.val) {
                    int val = cur.val;
                    cur.val = comp.val;
                    comp.val = val;
                }
                comp = comp.next;
            } while (comp != cur);
            cur = cur.next;
        }
        return head;
    }
}
