package com.one.skiplist;

import java.util.Comparator;

/**
 * @author one
 * @description 跳表的实现: 跳表是用来存储键值对的， 且是有序的，所以用<key, value>的形式存储
 * @date 2025-2-5
 */
public class SkipList<K, V> {

    /**
     * 跳表的最大层数：redis就是32层
     */
    private static final int MAX_LEVEL = 32;

    private int size;

    /**
     * 由于跳表是有序的， 所以需要一个比较器来比较key的大小
     */
    private Comparator<K> comparator;

    /**
     * 跳表当前的有效层数，从0开始， 不能超过最大层数
     */
    private int level;

    /**
     * 跳表虚拟头节点：不存储任何key和value, 只指向有效的Node节点
     */
    private Node<K, V> first;

    /**
     * 传入比较器的构造函数
     */
    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        this.first = new Node<>(null, null, MAX_LEVEL);
    }

    /**
     * 不传比较器的构造函数
     */
    public SkipList() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 通过key来查询value, 如果key存在则返回value, 如果key不存在则返回null
     */
    public V get(K key) {
        keyCheck(key);
        // 从跳表的第一层开始查找
        Node<K, V> node = first;
        // 从跳表的第一层开始查找
        for (int i = level - 1; i >= 0; i--) {
            // 找到第i层小于且最接近key的节点
            int cmp = -1;
            while (node.next[i] != null && (cmp = compare(key, node.next[i].key)) > 0) {
                node = node.next[i];
            }
            // 如果找到第i层小于且最接近key的节点， 且key相等，则找到了key对应的value
            if (cmp == 0) {
                return node.next[i].value;
            }
        }
        return null;
    }


    /**
     * 跳表中的key是有序的， 所以需要对Key进行判空
     */
    private void keyCheck(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
    }

    /**
     * 比较两个key的大小: 如果传入比较器就用比较器比较大小，否则就用Comparable接口比较大小
     */
    private int compare(K k1, K k2) {
        return comparator != null ? comparator.compare(k1, k2) : ((Comparable<K>) k1).compareTo(k2);
    }




    private static class Node<K, V> {
        K key;

        V value;

        /**
         * 由于跳表有多层， 所以用数组来存储下一个节点
         */
        Node<K, V>[] next;

        public Node(K key, V value,  int level) {
            this.key = key;
            this.value = value;
            this.next = new Node[level];
        }
    }
}
