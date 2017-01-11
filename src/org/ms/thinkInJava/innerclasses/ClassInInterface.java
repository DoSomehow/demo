package ms.innerclasses;

public interface ClassInInterface {

	void howdy();
	
	//接口中任何类都自动地是public和static的
	class Test implements ClassInInterface {
		public void howdy(){
			System.out.println("Howdy!");
		}
		
		//这怎么跑？
		public static void main(String[] args){
			new Test().howdy();
		}
	}
}
