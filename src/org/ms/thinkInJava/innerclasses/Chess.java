package ms.innerclasses;

public class Chess implements Game {

	private Chess() {}
	
	private int moves = 0;
	private static final int MOVES = 4;
	
	public boolean move(){
		System.out.println("Chess move " + moves);
		return ++moves != MOVES;
	}
	
	public static GameFactory factory = new GameFactory() {
		public Game getGame() {
			return new Chess();
		}
	};
}
