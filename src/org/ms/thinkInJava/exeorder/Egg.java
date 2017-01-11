package org.ms.thinkInJava.exeorder;

public class Egg {
	public Egg(){
		System.out.println("New Egg");
	}
	
	private Yolk y = new Yolk();  //和Egg的构造器比，还是这个先执行。
	
	public static void main(String[] args){
		Egg e = new Egg();
		
	}
	
}
