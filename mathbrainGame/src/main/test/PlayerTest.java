package game.maven.mathbrainGame;

import game.maven.mathbrainGame.Level;
import game.maven.mathbrainGame.Player;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	
	private Player player; 
	
	public void setUp() {
		player = new Player(); // Crear un nuevo jugador para cada prueba.
	}
	
	public void testGetHealth() {
        assertEquals(100, player.getHealth()); // Verificar si la salud inicial es 100
    }
	
	public void testHit() {
		player.hit(); // Reducir la salud del jugador.
		assertEquals("Los puntos de vida no coinciden", 95, player.getHealth()); // Verificar si la salud se redujo a 95.
	}
	
	public void testWinHeal() {
        player.setHealth(50); // Establecer la salud del jugador a 50
        player.winHeal(); // Incrementar la salud del jugador
        assertEquals("Los puntos de salud no coinciden", 55, player.getHealth()); // Verificar si la salud aumentó a 55
    }
	
	public void testNotDead() {
		assertFalse("El jugador no debe aparecer como muerto", player.dead()); // Verificar que teniendo puntos de vida, el jugador no apareza como muerto.
	}
	
	public void testDead() { 
		player.setHealth(0); // Establecer la salud del jugador en 0.
		assertTrue("El jugador debe aparecer como muerto", player.dead()); // Verificar si el jugador está muerto.
	}
	
	public void testDead2() {
		player.setHealth(-10); // Establecer la salud del jugador en negativo.
		assertTrue("El jugador debe aparecer como muerto", player.dead()); // Verificar si el jugador está muerto.
	}
	
	public void testUpdateScore() {
        boolean[] responses = {true, false, true, true, false, true}; // Respuestas correctas e incorrectas.
        Level level = new Level(player, true); // Nivel del jugador
        player.updateScore(responses, level); // Actualizar la puntuación del jugador
        assertEquals("Los puntajes no coinciden", 12, player.getScore()); // Verificar si la puntuación se actualizó correctamente
    }
}

