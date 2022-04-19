package com.mj.test;

import com.mj.bean.Animal;
import com.mj.printer.BinaryTrees;
import com.mj.tree.BinarySearchTree3;

/**
 * @ClassName: Main3
 * @Description: 测试Comparable接口的使用
 * @Author: one
 * @Date: 2021/07/21
 */
public class Main3 {
    public static void main(String[] args) {
        Animal animal=  new Animal("小狗",4);
        BinarySearchTree3<Animal> binarySearchTree3 = new BinarySearchTree3<>();
        binarySearchTree3.add(animal);

        BinarySearchTree3<Animal> searchTree3 = new BinarySearchTree3<>();
        // 使用传入比较器的构造方法来创建二叉树对象
        BinarySearchTree3<Integer> searchTree = new BinarySearchTree3<>((element1, element2) -> element1 - element2);
        int[] array = {7,4,9,2,1,3,5,9,8,10,11};
        for (int i : array) {
            searchTree.add(i);
        }
        BinaryTrees.println(searchTree);
//        searchTree.preOrderTraversal();
//        searchTree.inorderTraversal();
//        searchTree.postOrderTraversal();
        searchTree.levelOrderTraversal();
    }
}
