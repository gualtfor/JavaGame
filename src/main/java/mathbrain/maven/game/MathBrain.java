package mathbrain.maven.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class MathBrain extends Configurations {
	protected MainScreen mainscreen;
	protected String typed;
	
	public MathBrain() {
		super(Util.Max_R*2, Util.Max_R*2);
		mainscreen = MainScreen.getScreen();
		typed = "";
		start();
	}
	
	public void update() {
		mainscreen.update();
	}
	
	public void draw(Graphics g) {
		mainscreen.draw(g);
		g.setColor(Color.BLACK);
		g.drawString(typed, 5, 30);
	}
	
	public void keyTyped(KeyEvent ke) {
		if(ke.getKeyChar() == '\n' && typed.length() > 0) {
			mainscreen.tryKey(Integer.parseInt(typed));
		else
			mainscreen.player.addExp(mainscreen.getLevel().process(Integer.parseInt(typed)));
		typed = "";
		}
		if(Character.isDigit(ke.getKeyChar()))
			typed = typed + ke.getKeyChar();
	}
	
	public static void main(String[] args) {
		new.MathBrain().makeTestWindows();
	}
}