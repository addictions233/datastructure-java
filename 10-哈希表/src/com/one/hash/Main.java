package com.one.hash;

/**
 * @ClassName: Main
 * @Description: 计算hash值: int float long double String Object(hash值计算与内存地址有关)
 * @Author: one
 * @Date: 2021/01/16
 */
public class Main {
    public static void main(String[] args) {
        //测试字符串的哈希值
        String hashString = "zxkvb";
        char[] chars = hashString.toCharArray();
        int hash = 0;
        for (char aChar : chars) {
            //字符串的hash算法就是这么计算的
            hash = 31 * hash + aChar;
        }
        System.out.println(hash);
        // jdk官方计算字符串的hash值的方法
        System.out.println(hashString.hashCode());

        //测试自定义对象的hash值,怎么自定义对象的hash值
        Person person1 = new Person("zhangsan",180.5f,23);
        Person person2 = new Person("zhangsan",180.5f,23);
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }
}
