import java.util.ArrayList;

public class Player {
	
	static ArrayList<Player> pArray = new ArrayList<Player> ();

	private int hp = 20;
	private boolean active = false;
	private boolean alive = true;
	private String name = "";
	
	public static void changePlayerCount (int i) {
		if (i<pArray.size()) {
			while (i<Player.pArray.size()) {
				pArray.remove(pArray.size()-1);
			}
		}
		if (i>pArray.size()) {
			while (i>pArray.size()) {
				pArray.add(new Player());
			}
		}
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void plusHp(int hp) {
		this.hp += hp;
	}
	public void minusHp(int hp) {
		this.hp -= hp;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
