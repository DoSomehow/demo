package ms.innerclasses;

public class LocalInnerClass {
	private int count = 0;
	
	Counter getCounter(final String name){
		//局部内部类中不允许加访问修饰符，only abstract or final is permitted
		class LocalCounter implements Counter{
			public LocalCounter(){
				System.out.println("LocalCounter()");
			}
			public int next(){
				System.out.print(name);
				return count++;
			}
		}
		
		return new LocalCounter();
	}
	
	
	Counter getCounter2(final String name){
		return new Counter(){
			{
				System.out.println("Counter()");
			}
			
			public int next(){
				System.out.print(name);
				return count++;
			}
		};
	}
	
	public static void main(String[] args){
		LocalInnerClass lic = new LocalInnerClass();
		Counter c1 = lic.getCounter("Local inner");
		Counter c2 = lic.getCounter2("Anonymous inner");
		Counter c3 = lic.getCounter("Local inner2");
		Counter c4 = lic.getCounter2("Anonymous inner2");
		System.out.println(c1 == c3);  //false  传参换为一样还是false
		System.out.println(c2 == c4);  //false
		
//		for(int i=0; i<5; i++){
//			System.out.println(c1.next());
//		}
//		for(int i=0; i<5; i++){
//			System.out.println(c2.next());
//		}
		
	}
	
}
