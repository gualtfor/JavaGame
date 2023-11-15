package mathbrain.maven.game;

import java.awt.*;
import java.util.*;


public class MainScreen {
	public Player player;
	public Level[] levels;
	public int level = 0;
	public boolean lose = false;
	public boolean win = true;
	
	public MainScreen(Player player, Level... levels) {
		this.player = player
		this.levels = levels
	}
	
	public void tryKey(int key) {
		for(i=0; i < levels.length; i++) {
			if(levels[i].key == key) {
				level = i;
				i = levels.length;
			}
		}
	}
	
	public Level getLevel() {
		return levels[level];
	}
	
	public void update() {
		if(!win && !lose) {
			getLevel().update();
			player.hit(getLevel().getHitting());
			if(player.dead())
				lose = true
			if(getLevel().finished()) {
				player.heal();
				level++;
				if(level==levels.length) {
					win = true;
					level--;
				}
			}
		}
	}
	
	public void draw(Graphics g) {
		getLevel().drawEnemies(g);
		player.draw(g);
		g.setColor(Color.BLACK);
		g.drawString("Level: "+(level+1), 5, 15);
		g.drawString("Key: " + getLevel().key, Util.MAX_R*2-90, 15);
		if(win) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("Verdana", Font.BOLD, 14));
			g.drawString("You Win!", 140, 150);
		}
		if(lose) {
			g.setColor(Color.RED);
			g.setFont(new Font("Verdana", Font.BOLD, 14));
			g.drawString("You lose.", 140, 150);
		}
	}
	
	public static MainScreen getScreen() {
		Player player = new Player();
		
		//Level 1
		Vector<Enemy> stage1 = new Vector();
		for(int i =0; i < 5; i++) stage1.add(new Addition());
		for(int i =0; i < 5; i++) stage1.add(new Substraction());
		Level l1 = new level(2,141638, stage1)
				
		//level2
		Vector<Enemy> stage2 = new Vector();
		for(int i = 0; i < 5; i++) stage2.add(new Addition());
		for(int i = 0; i < 5; i++) stage2.add(new Multiplication());
		Level l2 = new Level(2,5278, stage2);
		
		//level3
		Vector<Enemy> stage3 = new Vector();
		for(int i = 0; i < 5; i++) stage3.add(new Addition());
		for(int i = 0; i < 5; i++) stage3.add(new Multiplication());
		Level l3 = new Level(3,5278, stage3);
		
		//level4
		Vector<Enemy> stage4 = new Vector();
		for(int i = 0; i < 5; i++) stage4.add(new Subtraction());
		for(int i = 0; i < 5; i++) stage4.add(new Multiplication());
		Level l4 = new Level(4,1947, stage4);
		
		//level5
		Vector<Enemy> stage5 = new Vector();
		for(int i = 0; i < 5; i++) stage5.add(new Addition());
		for(int i = 0; i < 5; i++) stage5.add(new Multiplication());
		Level l5 = new Level(4,56, stage4);
		
		//level6
		Vector<Enemy> stage6 = new Vector();
		for(int i = 0; i < 5; i++) stage6.add(new Subtraction());
		for(int i = 0; i < 5; i++) stage6.add(new Division());
		Level l6 = new Level(4,1947, stage6);
		
		//level7
		Vector<Enemy> stage7 = new Vector();
		for(int i = 0; i < 5; i++) stage7.add(new Division());
		for(int i = 0; i < 5; i++) stage7.add(new Multiplication());
		Level l7 = new Level(5,2, stage7);
		
		//level8
		Vector<Enemy> stage8 = new Vector();
		for(int i = 0; i < 5; i++) stage8.add(new DifficultAddition());
		for(int i = 0; i < 5; i++) stage8.add(new Multiplication());
		Level l8 = new Level(5,427, stage8);
		
		//level9
		Vector<Enemy> stage9 = new Vector();
		for(int i = 0; i < 5; i++) stage9.add(new DifficultAddition());
		for(int i = 0; i < 5; i++) stage9.add(new DifficultMultiplication());
		Level l9 = new Level(6,2, stage9);
		
		//level10
		Vector<Enemy> stage10 = new Vector();
		for(int i = 0; i < 5; i++) stage10.add(new Division());
		for(int i = 0; i < 5; i++) stage10.add(new DifficultMultiplication());
		Level l10 = new Level(6,5, stage10);
		
		return new MainScreen(player, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10)
	}
}