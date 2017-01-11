package ms.innerclasses;

public class Parcel8 {

	public Wrapping wrapping(int x){
		//这里返回的内容相当于是继承Wrapping类的一个类
		return new Wrapping(x){
			public int value(){
				return super.value() * 47;
			}
		};  //这个分号不是用来标记此内部类结束的，其实就是正常的分号，如 return x;
	}
	
//	public Wrapping wrapping(int x){
//		return new Wrapping(x);
//		
//	}
	
	public static void main(String[] args){
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);
		int y = w.value();
		System.out.println(y);
	}
}
