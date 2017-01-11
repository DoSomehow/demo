package org.ms.thinkInJava.holding;

import java.util.ArrayList;
import java.util.List;

public class Fuji extends Apple {
	
	public void sayHello(){
		System.out.println("Hi~ I am fuji");
	}
	
	public long getId(){
		return 1111l;  //覆盖父类的方法还是有效的
	}
	
	public static void main(String[] args){
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple());
		apples.add(new Fuji());
		
		for(int i=0; i<apples.size(); i++){
			System.out.println(apples.get(i).getId());  //向上转型为Apple，所以只有Apple中的方法
		}
	}
	
}
