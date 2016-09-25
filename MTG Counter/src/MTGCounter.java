public class MTGCounter {
	
	final static int STARTING_PLAYER_COUNT = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MTGCounter game = new MTGCounter ();
		Player.changePlayerCount(STARTING_PLAYER_COUNT);
		game.go();
	}
	
	private void go() {
		////initialize GUI builder////
		Gui gui = new Gui();
		gui.build();
	}
	
}
