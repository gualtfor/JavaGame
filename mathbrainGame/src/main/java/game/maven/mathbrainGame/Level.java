package game.maven.mathbrainGame;

import game.maven.mathbrain.Player;

public class Level {
	protected int level = 1;
	protected Player player;
	protected boolean active = true;
	
	public Level(Player player, boolean active) {
		this.player = player;
		this.active = active;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void levelUp(boolean[] response) {
		if(!player.dead() && getOneGoodAnswer(response)) {
			level += 1;
		}
	}
	
	public boolean getOneGoodAnswer(boolean[] response) {
		for(int i = 0; i < response.length; i++) {
			if(response[i]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean restLevels() {
		if(level <= 10)
			return true;
		return false;
	}
}

