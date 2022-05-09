package com.one.set;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: ListSet
 * @Description: 使用链表实现set集合
 * @Author: one
 * @Date: 2022/05/10
 */
public class ListSet<E> implements Set<E> {
    List<E> list = new LinkedList<E>();

    /**
     * 获取集合元素个数
     *
     * @return int
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * 集合是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 清空集合
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * 判断集合是否包含元素
     *
     * @param element 元素
     * @return boolean
     */
    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    /**
     * 添加元素
     *
     * @param element 元素
     */
    @Override
    public void add(E element) {

    }

    /**
     * 删除元素
     *
     * @param element 元素
     */
    @Override
    public void remove(E element) {

    }

    /**
     * 遍历集合
     *
     * @param visitor
     */
    @Override
    public void traversal(Visitor<E> visitor) {

    }
}
