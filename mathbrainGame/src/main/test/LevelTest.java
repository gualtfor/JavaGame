package game.maven.mathbrainGame;

import game.maven.mathbrainGame.Level;
import game.maven.mathbrainGame.Player;
import junit.framework.TestCase;

public class LevelTest extends TestCase {
	
	private Level level;
	private Player player;
	
	public void setUp() {
		player = new Player(); // Crear un nuevo jugador para cada prueba.
		level = new Level(player, true); // Inicializar el nivel.
	}
	
	public void testCurrentLevel () {
		assertEquals("El nivel no coincide", 1, level.getLevel()); // Verificar si el nivel comienza en 1.
	}
	
	public void testGetOneGoodAnswer() {
        boolean[] responses = {false, true, false}; // Array con una respuesta correcta en la posición 1.
        assertTrue(level.getOneGoodAnswer(responses)); // Verificar si al menos una respuesta es correcta.
    }
	
	public void testRestLevels() {
        assertTrue(level.restLevels()); // Verificar si el nivel es menor o igual a 10 al inicio
        level.updateLevel(11); // Establecer un nivel superior a 10
        assertFalse(level.restLevels()); // Verificar si el nivel es mayor que 10
    }
	
	public void testLevelUp() {
        boolean[] responses = {false, true, false}; // Array con una respuesta correcta en la posición 1
        level.levelUp(responses); // Incrementar el nivel con una respuesta correcta
        assertEquals("El nivel no coincide", 2, level.getLevel()); // Verificar si el nivel aumentó a 2
        level.levelUp(new boolean[]{false, false, false}); // Intentar aumentar el nivel sin respuestas correctas
        assertEquals("El nivel no coincide", 2, level.getLevel()); // Verificar que el nivel se mantuvo en 2
    }
	
}