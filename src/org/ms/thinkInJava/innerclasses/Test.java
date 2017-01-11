package ms.innerclasses;

public class Test {

	public Test(){
		System.out.println("constructor");
	}
	
	{
		System.out.println("static");
	}
	
	public static void main(String[] args){
		Test t = new Test();
		
	}
}
