package game.maven.mathbrainGame;

import java.util.*;
/*import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;*/
import javafx.util.Pair;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Clase que contiene toda la logica del juego.

/**
 * Clase que posee todas las reglas y la estructura del juego.
 */

public class LogicOfGame {
	static Random random = new Random();
	private static final Logger logger = LogManager.getLogger(LogicOfGame.class);
	
	/**
	 * Metodo que selecciona si el modo del juego es multijugador o de unico jugador.
	 * @return Un booleano que representa si el juego es multijudor (true) o unico jugador (false)
	 */
	public static boolean isMultiplayer() {
		System.out.println("Enter true or false if you want multiplayer: ");
		Scanner scanner = new Scanner(System.in);
		boolean key = true;
		while(key) {
			if(scanner.hasNextBoolean()) {
				return scanner.nextBoolean();
			} else {
				logger.error("Error in method isMultiplayer");
			}
		}
		scanner.close();
		return false;
	}
	
	/**
	 * Metodo que selecciona el nivel e implementa todas las operaciones matematicas para cada nivel.
	 * @param player Es la clase que represeta al jugador actual
	 * @param level Es la clase que representa el nivel actual
	 */
	private void selectionLevel(Player player, Level level) {
		int choice = level.getLevel();
		switch(choice) {
		case 1:
			System.out.println("You are in level 1");
			process("Addition", "Subtraction",  random.nextInt(25) + 1, player, level);
			break;
		case 2:
			System.out.println("You are in level 2");
			process("Addition", "Multiplication", random.nextInt(11) + 1, player, level);
			break;
		case 3:
			System.out.println("You are in level 3");
			process("Addition", "Multiplication", random.nextInt(12) + 1, player, level);
			break;
		case 4:
			System.out.println("You are in level 4");
			process("Subtraction", "Multiplication", random.nextInt(13) + 1, player, level);
			break;
		case 5:
			System.out.println("You are in level 5");
			process("Addition", "Multiplication", random.nextInt(14) + 1, player, level);
			break;
		case 6:
			System.out.println("You are in level 6");
			process("Subtraction", "Division", random.nextInt(16) + 1, player, level);
			break;
		case 7:
			System.out.println("You are in level 7");
			process("Division", "Multiplication", random.nextInt(18) + 1, player, level);
			break;
		case 8:
			System.out.println("You are in level 8");
			process("DifficultAddition", "Multiplication", random.nextInt(20) + 1, player, level);
			break;
		case 9:
			System.out.println("You are in level 9");
			process("DifficultAddition", "DifficultMultiplication", random.nextInt(21) + 1, player, level);
			break;
		case 10:
			System.out.println("You are in level 10");
			process("Division", "DifficultMultiplication", random.nextInt(21) + 1, player, level);
			break;
		}
			
	}
		
	/**
	 * Metodo que realiza el llamado de los metodos que realizan las operaciones matematicas.
	 * @param operation1 Es el nombre de la primera operacion 
	 * @param operation2 Es el nombre de la segunda operacion
	 * @param whatelse Es un número entero aleatorio 
	 * @param player Es la clase que represeta al jugador actual 
	 * @param level Es la clase que representa el nivel actual
	 */
	public void process(String operation1, String operation2, int whatelse, Player player, Level level) {
		ArrayList<Pair<String, Integer>> operations = new ArrayList<>();
		for(int i =0; i < 5; i++) {
			Operations assessment1 = getMethodOperation(operation1);
			Operations assessment2 = getMethodOperation(operation2);
			if (assessment1 != null && assessment2 != null) {
				operations.add(assessment1.assessment(whatelse));
				operations.add(assessment2.assessment(random.nextInt(whatelse)));
			} else {
				logger.error("There is an error in process method");
				System.out.println("There is an error in process method");
			}
		}
		answers(operations, player, level);
	}
	
	/**
	 * Metodo que realiza la seleccion de la operación que se debe realizar.
	 * @param oper1 Nombre de la operacion matematica
	 * @return La inicializacion de la clase que representa la operación matematica.
	 */
	private static Operations getMethodOperation(String oper1) {
		switch(oper1){
			case "Addition":
				return new Addition();
			case "Subtraction":
				return new Subtraction();
			case "Multiplication":
				return new Multiplication();
			case "Division":
				return new Division();
			case "DifficultAddition":
				return new DifficultAddition();
			case "DifficultMultiplication":
				return new DifficultMultiplication();
			default:
				 return null;
		}
	}
	
	/**
	 * Metodo que permite el ingreso de las respuestas a las preguntas del juego.
	 * @param questions Representa un Array de las descripciones de las operaciones y sus respuestas.
	 * @param player Es la clase que represeta al jugador actual.
	 * @param level Es la clase que representa el nivel actual.
	 * @return Un array con las respuestas de las operaciones.
	 */
	public Integer[] answers(ArrayList<Pair<String, Integer>> questions, Player player, Level level){
		Scanner scanner = new Scanner(System.in);
		Integer[] answerQuestions = new Integer[10];
		System.out.println("Please, answer these questions: ");
		for(int i = 0; i < 10; i++) {
			System.out.println(questions.get(i).getKey());
			if(scanner.hasNextInt()) {
				answerQuestions[i] = scanner.nextInt();	
			} else {
				logger.error("Error message");
				i--;
			}
		}
		boolean[] checkanswers = compareAnswersQuestions(answerQuestions, questions, player, level);
		player.updateScore(checkanswers, level);
		level.levelUp(checkanswers);
		System.out.println("The health points are: " + player.health);
		return answerQuestions;
	}
	
	/**
	 * Metodo que realiza la comparación entre las respuestas del usuario y las del juego.
	 * @param answerQuestions Representa un Array que contiene las respuestas del usuario.
	 * @param questions Representa un Array de las descripciones de las operaciones y sus respuestas.
	 * @param player Es la clase que represeta al jugador actual.
	 * @param level Es la clase que representa el nivel actual.
	 * @return Un array de booleanos con la respuesta de las comparaciones. Es true si la respuesta del usuario es igual a la del juego
	 */
	private boolean[] compareAnswersQuestions(Integer[] answerQuestions, 
			ArrayList<Pair<String, Integer>> questions, Player player, Level level) {
		int count = 0;
		int i = 0;
		boolean[] checkAnswer = new boolean[10];
		for(i = 0; i < 10; i++) {
			if(questions.get(i).getValue().equals(answerQuestions[i])){
				checkAnswer[i] = true;
				count += 1;
			} else {
				checkAnswer[i] = false;
				player.hit();
			}
			if((i == 4 || i ==9)) {
				if(count == 5) {
					player.winHeal();
				} else {
					count = 0;
				}
			}
		}
		return checkAnswer;
	}
	
	/**
	 * Metodo que imprime las respuestas de las comparaciones entre las respuestas del usuario y las del juego.
	 * @param answers Representa un array de booleanos con la respuesta de las comparaciones.
	 */
	public void printScreen(boolean[] answers) {
		for(int i = 0; i < 10; i++) {
			System.out.print(answers[i]);
		}
	}

	/**
	 * Representa el metodo principal que realiza las llamadas a las principales metodos. Tambien realiza las inicializaciones de todas
	 * las clases como player y level
	 */
	public void beginning() {	
		if(isMultiplayer()) {
			boolean isObject1Turn = true;
			boolean controlExecution = true;
			Player player1 = new Player();
			Player player2 = new Player();
			int previousLevelPlayer1 = 1;
			int previousLevelPlayer2 = 1;
			
			while((!player1.dead() || !player2.dead()) && controlExecution) {
				System.out.println("You are in mode Multiplayer:");
				Level level1 = new Level(player1, player1.dead());
				level1.level = previousLevelPlayer1;
				Level level2 = new Level(player2, player2.dead());
				level2.level = previousLevelPlayer2;
				
				if(isObject1Turn && !player1.dead() && level1.restLevels()) {
					selectionLevel(player1, level1);
				}else if(!isObject1Turn && !player2.dead() && level2.restLevels()) {
					selectionLevel(player1, level2);
				}
				
				if(!level1.restLevels() && !level2.restLevels()) {
					controlExecution = false;
				}else if (player1.dead() && !level2.restLevels()) {
					controlExecution = false;
				}else if (player2.dead() && !level1.restLevels()) {
					controlExecution = false;
				}
				
				isObject1Turn = !isObject1Turn;
				previousLevelPlayer1 = level1.level;
				previousLevelPlayer2 = level2.level;
			}
		} else {
			System.out.println("You are in mode single player:");
			boolean control = true;
			Player player3 = new Player();
			int previousLevel = 1;
			
			while(!player3.dead() && control) {
				Level level3 = new Level(player3, player3.dead());
				level3.level = previousLevel;
				selectionLevel(player3, level3);
				control = level3.restLevels();
				previousLevel = level3.level;
			}
		}
	}
}