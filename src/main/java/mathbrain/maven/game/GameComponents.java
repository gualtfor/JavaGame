package mathbrain.maven.game;

import java.awt.*;
import java.util.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;

public abstract class GameComponents extends Components implements MouseListener, MouseMotionListener, KeyListener{
	public boolean mousePressed1 = false, mousePressed2 = false, mousePressed3 = false;
	public ArrayList<String> keysPressed = new ArrayList();
	public boolean debug = false;
	
	public int mouseX = 0;
	public int mouseY = 0;
	
	public GameComponents(int widht, int hight) {
		super(widht, hight);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}
	
	public void mouseClicked(MouseEvent e){}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == e.BUTTON1)
			mousePressed1 = true;
		if(e.getButton() == e.BUTTON2)
			mousePressed2 = true;
		if(e.getButton() == e.BUTTON3)
			mousePressed3 = true;
	}
	
	public void mouseDragged(MouseEvent e) {
		if(e.getButton() == e.BUTTON1)
			mousePressed1 = !mousePressed1;
		if(e.getButton() == e.BUTTON2)
			mousePressed2 = !mousePressed2;
		if(e.getButton() == e.BUTTON3)
			mousePressed3 = !mousePressed3;		
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	public void mouseMoved(MouseEvent e) {
		mousePressed1 = false;
		mousePressed2 = false;
		mousePressed3 = false;
		
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	public void keyPressed(KeyEvent e) {
		if(debug)
			System.out.println(e.getKeyText(e.getKeyCode()));
		keysPressed.add(e.getKeyText(e.getKeyCode()));
	}
	
	public void keyReleased(KeyEvent e)
	{
		for(int i = 0; i < keysPressed.size(); i++) {
			if(keysPressed.get(i).equals(e.getKeyText(e.getKeyCode()))) {
				keysPressed.remove(i);
				i--;
			}
		}
	}
	
	public boolean isMousePressed(int b) {
		if(b == 1)
			return mousePressed1;
		else if(b == 2)
			return mousePressed2;
		else if(b == 3)
			return mousePressed3;
		return false;
	}
	
	public boolean isMousePressed()
	{
		if(mousePressed1)
			return mousePressed1;
		else if(mousePressed2)
			return mousePressed2;
		else if(mousePressed3)
			return mousePressed3;
		return false;		
	}
	
	public boolean isKeyPressed(String k) {
		for(int i = 0; i < keysPressed.size(); i++) {
			if(keysPressed.get(i).equalsIgnoreCase(k)) {
				return true;
			}
		}
		return false;
	}
	
	public int getKeysPressed() {
		return keysPressed.size();
	}
	
	public void resetKeys() {
		keysPressed = new ArrayList();
	}
}
