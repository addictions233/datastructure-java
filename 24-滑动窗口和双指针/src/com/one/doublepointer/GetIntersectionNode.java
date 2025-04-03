package com.one.doublepointer;

/**
 * @description: 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @author: wanjunjie
 * @date: 2025/04/03
 */
public class GetIntersectionNode {

  public class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null? a.next : headB;
            b = b != null? b.next : headA;
        }
        return a;
    }
}
