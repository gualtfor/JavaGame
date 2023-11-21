package game.maven.mathbrainGame;

import java.util.*;
//Esta clase contiene todas las caracteristicas y metodos del jugador.

/**
 * Clase que contiene toda la información acerca del nivel que esta jugando el jugador.
 * 
 */
public class Level extends Player{
	protected int level = 1;
	protected Player player;
	protected boolean active = true;
	
	public Level(Player player, boolean active) {
		this.player = player;
		this.active = active;
	}
	
	/**
	 * Metodo que retorna el nivel actual en el que se encuentra el jugador.
	 * @return Regresa un número entero entre 1 y 10 
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Metodo que realiza la actualización de los niveles del jugador. Para que el jugador avance de nivel el jugador debe tener
	 * puntos de vida y por lo menos tener una pregunta bien.
	 * @param response Es un array de booleanos donde fueron comparados los valores aportados por el usuario y por el juego. Un valor es 
	 * true si la respuesta aportada por el usuario es igual a la del sistema.
	 */
	public void levelUp(boolean[] response) {
		if(!player.dead() && getOneGoodAnswer(response)) {
			level += 1;
		}
		updateLevel(level);
		System.out.println("Your level is: " + level);
	}
	
	/**
	 * Metodo que verifica que por lo menos hay una respuesta correcta en las respuestas que aporto el usuario.
	 * @param response Es un array de booleanos donde fueron comparados los valores aportados por el usuario y por el juego. Un valor es 
	 * true si la respuesta aportada por el usuario es igual a la del sistema.
	 * @return Un booleano true si hay por lo menos una respuesta correcta o false si todas las respuestas estan incorrectas.
	 */
	public boolean getOneGoodAnswer(boolean[] response) {
		for(int i = 0; i < response.length; i++) {
			if(response[i]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que revisa si existen mas niveles por jugar.
	 * @return Un booleano true si existen más niveles y false si el jugador a terminado todos los niveles.
	 */
	public boolean restLevels() {
		if(level <= 10)
			return true;
		return false;
	}
	
	/**
	 * Metodo que actualiza el nivel del jugador.
	 * @param newScore Es un entero que identifica el nuevo nivel del jugador.
	 */
	public void updateLevel(int newScore) {
		this.level = newScore;
	}
}


