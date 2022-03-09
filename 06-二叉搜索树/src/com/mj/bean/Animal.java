package com.mj.bean;

/**
 * @ClassName: Animal
 * @Description: 使用BinarySearchTree中存储Animal对象
 * @Author: one
 * @Date: 2021/07/21
 */
public class Animal implements Comparable<Animal> {
    private String name;
    private int legs;

    public Animal() {
    }

    public Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }


    /**
     * 重写Comparable接口中的CompareTo方法
     * @param animal
     * @return
     */
    @Override
    public int compareTo(Animal animal) {
        return this.legs - animal.legs;
    }

}
