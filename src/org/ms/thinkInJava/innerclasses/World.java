package ms.innerclasses;


public class World {
	
	public interface Contents {
		public int value();
	}
	
	public void sayHello(){
		System.out.println("Hello World!");
	}
	
	public class China {
		//普通内部类中的字段和方法，只能
//		private static String SPECIAL = "中国特色";
		
		public void sayNiHao(){
			System.out.println("NiHao China!");
		}
	}
	
	public China getChina(){
		return new China();
	}
	
	public static void main(String[] args){
		//不能直接new，必须先有一个外部类的对象才可以new
		//		China c = new China();
		World w = new World();
		China c = w.new China();
		w.sayHello();
		c.sayNiHao();
	}
	
}
