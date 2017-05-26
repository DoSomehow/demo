package org.ms.javaTest.testConstructor;

/**
 * 测试子类初始化构造器时，是否会先执行所有基类中的构造器
 * Created by Administrator on 2017/1/10.
 */
public class ConstructorC extends ConstructorB {
    public ConstructorC(){
        super();
        System.out.println("Constructor C");
    }

    public static void main(String[] args) {
        ConstructorC c = new ConstructorC();
    }
}
