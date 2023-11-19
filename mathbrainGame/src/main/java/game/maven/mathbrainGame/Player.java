package game.maven.mathbrainGame;


import java.util.*;

public class Player {
	protected int maxHealth = 100;
	protected int health = maxHealth;
	protected int amount = 5;
	protected int winHealth = 0;
	protected int score = 0;
	
	public void hit() {
		health -= amount;
	}
	
	public void winHeal() {
		winHealth = health + amount; 
		if(winHealth <= 100 && health > 0) {
			health = winHealth;
		}
		winHealth = 0;
	}
	
	public boolean dead() {
		return health <= 0;
	}
	
	public void updateScore(boolean[] answers, Level level) {
		for(int i = 0; i < answers.length; i++) {
			switch(level.getLevel()) {
				case 1:
				case 2:
				case 3:
					if(answers[i]) {
						score += 3;
					}
					break;
				case 4:
				case 5:
				case 6:
				case 7:
					if(answers[i]) {
						score += 4;
					}
					break;
				case 8:
				case 9:
				case 10:
					if(answers[i]) {
						score += 5;
					}
					break;
			}
		}
		System.out.println("the score is: " + score);
	}
}
