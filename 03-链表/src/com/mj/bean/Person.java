package com.mj.bean;

import java.util.Objects;

/**
 * 	存储的元素工具类
 * @author one
 *
 */
public class Person {
	private String name;
	private int age;
	
	//有参构造方法
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	@Override
	public String toString() {
		return "Person:[name="+name+",age="+age+"]";
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Person - finalize");
	
	}
	/*
	 * 	为什么要用强转类型转换?  
	 * 		多态的缺点, 父类引用指向子类的对象,父类不能使用子类特有的成员, instanceOf关键字判断前面对象的实际类型是不是后面类的派生类
	 * 		这样就可以将父类类型的对象变量强制转换为它的实际类型,来调用它的实例类型里面特有的成员
	 */
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
	
	
}
