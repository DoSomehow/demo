package ms.innerclasses;

public class DotThis {

	private String name;
	
	public DotThis(String str){
		this.name = str;
	}
	
	public void f(){
		System.out.println("DotThis.f() " + name);
	}
	
	public class Inner {
		public DotThis getOuter(){
			return DotThis.this;  //返回对外部类对象的引用
		}
	}
	
	public Inner getInner(){
		return new Inner();
	}
	
	public static void main(String[] args){
		DotThis dt = new DotThis("Ryan");
		DotThis dt2 = new DotThis("wsy");
		Inner dti = dt.getInner();
		Inner dti2 = dt2.getInner();
		dti.getOuter().f();
		dti2.getOuter().f();
	}
}
