package ms.innerclasses;

public class Games {

	public static void playGame(GameFactory factory){
		Game s = factory.getGame();
		while(s.move()){
			//do something
		}
	}
	
	public static void main(String[] args){
//		playGame(Checkers.factory);
		playGame(Chess.factory);
		
		Checkers c = new Checkers();
		playGame(c.factory);
	}
}
