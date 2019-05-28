package org.ms.thinkInJava.interfaces.inherit;

public class InheritInner extends WithInner.Inner {  //如果是接口的时候，就不会这么复杂了

		//因为内部类的构造器必须连接到指向其外围类对象的引用，所以在继承内部类的时候，事情会变得有点复杂
		//问题在于，那个指向外围类对象的“秘密的”引用必须被初始化，而在导出类中不再存在可连接的默认对象。
	
		public InheritInner(WithInner wi) {  //传入外围类对象的引用，并调用super方法
			wi.super();
		}
		
		public static void main(String[] args){
			WithInner wi = new WithInner();
			InheritInner ii = new InheritInner(wi);
		}
		
}
