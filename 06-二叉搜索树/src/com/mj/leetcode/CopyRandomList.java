package com.mj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 138. 随机链表的复制
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * @author: wanjunjie
 * @date: 2025/04/02
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> copyMap = new HashMap<Node, Node>();
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            copyMap.put(temp, copy);
            temp = temp.next;
        }
        Node result = copyMap.get(head);
        for (Map.Entry<Node, Node> entry : copyMap.entrySet()) {
            Node source = entry.getKey();
            Node target = entry.getValue();
            if (source.next != null) {
                target.next = copyMap.get(source.next);
            }
            if (source.random != null) {
                target.random = copyMap.get(source.random);
            }
        }
        return result;
    }
}
