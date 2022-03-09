package com.mj.bean;

/**
 * @InterfaceName: Comparator
 * @Description: Comparator比较器能够更灵活的设置比较规则,也不强制要求二叉搜索树中传入的类型必须实现Comparable接口,
 *              既能灵活的设置比较规则,也能
 * @Author: one
 * @Date: 2021/07/21
 */
@FunctionalInterface
public interface Comparator<E> {
    /**
     * 比较器接口中的比较方法
     * @param element1 元素1
     * @param element2 元素2
     * @return int
     */
    int compare(E element1, E element2);
}
