package com.mj.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @author: wanjunjie
 * @date: 2025/04/03
 */
public class DetectCycle {


    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
