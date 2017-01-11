package ms.innerclasses.cb;

public class Caller {
	private Incrementable callbackRef;
	
	Caller(Incrementable cbh){
		callbackRef = cbh;
	}
	
	void go(){
		callbackRef.increment();
	}
}
