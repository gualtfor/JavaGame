package game.maven.mathbrainGame;


import java.util.*;

// Esta clase representa al jugador además contiene todas las caracteristicas de este.

/**
 * Clase que contiene la session del jugador con las caracteristicas y metodos del mismo.
 */

public class Player {
	protected int maxHealth = 100;
	protected int health = maxHealth;
	protected int amount = 5;
	protected int winHealth = 0;
	protected int score = 0;
	
	/**
	 * Este metodo reduce los punto de vida del jugador cuando ha contestado mal una pregunta. Siempre por cada pregunta incorrecta 
	 * se descontaran 5 puntos de vida.
	 */
	public void hit() {
		health -= amount;
	}
	
	/**
	 * Este metodo actualiza los puntos de vida del jugador cuando ha contestado de forma correcta las primeras 5 preguntas o las ultimas
	 * 5 preguntas.
	 * Adicionalmente un Jugador nunca podra tener más de 100 puntos de vida por lo que los puntos de vida del bono se perderan si este 
	 * tiene 0 puntos de vida o tiene 100. 
	 */
	public void winHeal() {
		winHealth = health + amount; 
		if(winHealth <= 100 && health > 0) {
			health = winHealth;
		}
		winHealth = 0;
	}
	
	/***
	 * Este metodo valida si el jugador posee puntos de vida. Se considera que perdio el jugador cuando este tiene 0 puntos.
	 */
	public boolean dead() {
		return health <= 0;
	}
	
	/**
	 * Este metodo actualiza el puntaje que ha tenido el jugador en cada nivel. Dependiendo del nivel el jugados obtendra 
	 * diferentes puntos.
	 * @param answers Es un array de valores booleanos donde se ha validado si la respuesta del usuario es igual a la aportada por el juego
	 * @param level Es la clase que contiene todas las caracteristicas del nivel que el jugador esta jugando.
	 */
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
