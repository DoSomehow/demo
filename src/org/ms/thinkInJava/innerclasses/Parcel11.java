package ms.innerclasses;


public class Parcel11 {
	
	private static String name = "Outer static name";
	
	public void setName(String s){
		name = s;
	}
	
	public void getName(){
		System.out.println(name);
	}
	
	public interface Destination {
		public void setInnerName(String s);
		public void getOuterName();
	}
	
	public interface AnotherInterface {
		//用来测试内部类继承多个接口
		//要说还得测试一下同时继承类和接口
	}

	//可以继承其他类中的内部类
	private static class ParcelContents implements World.Contents {
		private int i = 11;
		public int value(){
			return i;
		}
	}
	
	protected static class ParcelDestination implements Parcel11.Destination, Parcel11.AnotherInterface {
		private String label;
		private String name;  //这个存在时，name指向的都是该内部类的name，而不是Parcel11中的name
		private ParcelDestination(String whereTo){
			label = whereTo;
		}
		public String readLabel(){ return label; }
		
		public static void f() {}
		static int x = 10;
		static class AnotherLevel {
			public static void f() {}
			static int x = 10;
		}
		
		public void setInnerName(String s){
			name = s;
		}
		
		public void getOuterName(){
			//使用外部类中的静态数据
			//可以访问外部类中的私有数据
			System.out.println(Parcel11.name);  //不能从嵌套类的对象中访问非静态的外围类对象
			System.out.println(name);
		}
	}
	
	//嵌套类中放普通内部类
	public class NormalInner {
		public void f(){
			System.out.println("Normal Inner Class");
		}
	}
	
	public static Destination destination(String s){
		return new ParcelDestination(s);
	}
	
	public static World.Contents contents(){
		return new ParcelContents();
	}
	
	public static void main(String[] args){
		World.Contents c = contents();
		Destination d = destination("Ryan");
		
		d.setInnerName("wsy");
		d.getOuterName();
		
		Parcel11 p = new Parcel11();
		NormalInner ni = p.new NormalInner();
		ni.f();
		
	}
	
}
