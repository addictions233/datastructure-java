package com.one.hash;

/**
 * @ClassName: Person
 * @Description: 计算自定义对象的hash值, 如果不重写Object类中的hashCode()方法,计算hash值与内存地址有关
 * @Author: one
 * @Date: 2021/01/16
 */
public class Person {
    private String name;
    private float height;
    private int age;

    public Person(String name,float height,int age){
        this.name = name;
        this.height =height;
        this.age =age;
    }
    /**
     *  如何计算自定义对象的hash值
     */
    @Override
    public int hashCode(){
        int hashCode = (null == name ? 0:name.hashCode());
        hashCode = hashCode * 31 + Float.hashCode(height);
        hashCode = hashCode * 31 + Integer.hashCode(age);
        return hashCode;
    }

    /**
     *  重写equals()方法是为了确定两个对象是否相等,不重写的话equals()方法是比较地址值
     *  hash值相同的对象不一定equals方法返回true,但是equals返回true的两个对象的hash值一定相同
     *  所以确定两个对象是否相等,只能依靠equals()方法来比较,不能依靠hashCode()方法来比较对象是否相等
     */
    @Override
    public boolean equals(Object object){
        //地址值相同肯定是同一对象
        if(this == object){
            return true;
        }
        //字节码对象不相同肯定就不是同一个类,那么肯定不是同一对象
        if( null == object || this.getClass() != object.getClass()){
            return false;
        }
        // 强制类型转换,由于上面利用字节码对象进行了判断,所以不会出现类型转换异常
        Person person = (Person) object;
        // Person类中进行equals比较的内容
        return this.name == null ? person.name == null : this.name.equals(person.name)
                && this.height == person.height
                && this.age == person.age;
    }

}
