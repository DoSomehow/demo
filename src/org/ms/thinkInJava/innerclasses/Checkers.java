package ms.innerclasses;

public class Checkers implements Game {

	public Checkers() {} 
	
	private int moves = 0;
	private static final int MOVES = 3;
	
	public boolean move(){
		System.out.println("Checkers move " + moves);
		return ++moves != MOVES;
	}
	
	public GameFactory factory = new GameFactory() {
		public Game getGame() {
			return new Checkers();
		}
	};
}
