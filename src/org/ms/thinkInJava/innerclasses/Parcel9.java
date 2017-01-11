package ms.innerclasses;




public class Parcel9 {

	public Destination destination(final String dest){
		return new Destination(){
			private String label = dest;
			public String readLabel(){
				return label;
			}
		};
	}
	
	public IPerson getPerson(){
		return new IPerson() {  //接口也是可以的
			public void eat() {
				System.out.println("mixed");
			}
		};
	}
	
	public static void main(String[] args){
		Parcel9 p = new Parcel9();
		Destination d = p.destination("wangshangyu");
		IPerson n = p.getPerson();
		n.eat();
	}
}
