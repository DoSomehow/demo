package org.ms.thinkInJava.holding;

import java.util.ArrayList;
import java.util.List;

public class Apple {

	private static long counter;
	{ System.out.println("static:"+counter); }
	private final long id = counter++;
	public long getId() {
		return id;
	}
	
	public static void main(String[] args){
		List<Apple> apples = new ArrayList<Apple>();
		for(int i=0; i<3; i++){
			apples.add(new Apple());
		}
		
		for(int i=0; i<apples.size(); i++){
			System.out.println(apples.get(i).getId());
		}
		
		//为什么没有任何给counter赋值的情况，但会出现这样的结果？
		//1. 初始化时，自动给long类型默认初始值。 2. 这就要提到“类加载时...”，也就是第一次创建Apple对象时，即虚拟机第一次加载Apple类时，此时
		//初始化static变量，且该变量只有一份，所有Apple的对象共享
	}
	
}
