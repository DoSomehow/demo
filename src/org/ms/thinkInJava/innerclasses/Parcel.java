package ms.innerclasses;

public class Parcel {

	class Contents {
		private int i = 11;
		public int value() { return i; }
	}
	
	class Destination {
		private String label;
		Destination(String whereTo){
			label = whereTo;
		}
		String readLabel() { return label; }
	}
	
	public Contents contents(){
		return new Contents();
	}
	
	public Destination to(String s){
		return new Destination(s);
	}
	
	public void ship(String dest){
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
	}
	
	public static void main(String[] args){
		Parcel p = new Parcel();
		p.ship("zhengzhou");
		
		Parcel q = new Parcel();
//		Parcel.Contents c = q.contents();
//		Parcel.Destination d = q.to("xinmi");
		Contents c = q.contents();
		Destination d = q.to("xinmi");
		//书上说，如果想从外部类的非静态方法之外的任意位置创建某个内部类的对象，那么必须像在main()方法中那样，具体地指明这个对象的类型：OuterClassName.InnerClassName
		//但为什么这里我尝试时，去掉了外部类，并没有报错？难道是这样的话，会导致与外部类关联不起来？
		
//		Contents c1 = new Contents();
//		Destination d1 = new Destination("xinzheng");
		
		Contents c2 = q.new Contents();
		Destination d2 = q.new Destination("dengfeng");
	}
}
