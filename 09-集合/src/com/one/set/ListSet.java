package com.one.set;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: ListSet
 * @Description: Set集合:对元素进行去重,使用链表实现set集合
 * @Author: one
 * @Date: 2022/05/10
 */
public class ListSet<E> implements Set<E> {
    private final int ELEMENT_NOT_FUND = -1;

    /**
     * 使用链表实现Set集合, 需要持有一个LinkedList
     * 最终集合元素都是存储在链表中
     */
    private List<E> list = new LinkedList<E>();


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
     * 添加元素: set集合的元素不能重复
     *
     * @param element 元素
     */
    @Override
    public void add(E element) {
        // 查询是否存在重复元素, 进行去重
        int index = list.indexOf(element);
        if(index == ELEMENT_NOT_FUND) {
            list.add(element);
        } else {
            // 使用新元素覆盖旧元素
            list.set(index, element);
        }
    }

    /**
     * 删除元素
     *
     * @param element 元素
     */
    @Override
    public void remove(E element) {
        int index = list.indexOf(element);
        if (index != ELEMENT_NOT_FUND) {
            list.remove(element);
        }
    }

    /**
     * 遍历集合
     *
     * @param visitor
     */
    @Override
    public void traversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        // 遍历list集合
        int size = list.size();
        for (int i = 0; i < size; i++) {
            visitor.visit(list.get(i));
        }
    }
}
