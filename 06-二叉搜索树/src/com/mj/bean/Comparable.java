package com.mj.bean;

/**
 * @ClassName: Comparable
 * @Description: 因为二叉搜素树中存储的元素必须是具有可比较性的,如何限定二叉搜索树中传入的元素是具有可比较性的?
 *              使用泛型限定二叉搜索树中存入的元素类型, 元素类型必须实现我们自定义的Comparable接口,
 *              java常有的数据类型都实现了jdk自带的Comparable接口
 * @Author: one
 * @Date: 2021/07/21
 */
@FunctionalInterface
public interface Comparable<E> {
    /**
     * 比较的方法
     * @param element 元素对象
     * @return int
     */
    int compareTo(E element);
}
