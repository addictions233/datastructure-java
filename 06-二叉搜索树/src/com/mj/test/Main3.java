package com.mj.test;

import com.mj.bean.Animal;
import com.mj.bean.Comparator;
import com.mj.printer.BinaryTrees;
import com.mj.tree.BinarySearchTree3;

import javax.sound.midi.Soundbank;

/**
 * @ClassName: Main3
 * @Description: 测试Comparable接口的使用
 * @Author: one
 * @Date: 2021/07/21
 */
public class Main3 {
    public static void main(String[] args) {
        Animal animal=  new Animal("小狗",4);
        System.out.println(animal.compareTo(new Animal("小鸡",2)));

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
        // 二叉树前序遍历的结果打印
        searchTree.preorderTraversal(System.out::println);
//        searchTree.inorderTraversal();
        searchTree.levelOrderTraversal(i -> System.out.println(i + 10));
    }
}
