package game.maven.mathbrainGame;

import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogicOfGame {
	static Random random = new Random();
	private static final Logger logger = LogManager.getLogger(LogicOfGame.class);
	
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
	
	public void printScreen(boolean[] answers) {
		for(int i = 0; i < 10; i++) {
			System.out.print(answers[i]);
		}
	}
	
	
	
	public void beginning() {	
		if(isMultiplayer()) {
			boolean isObject1Turn = true;
			boolean controlExecution = true;
			Player player1 = new Player();
			Player player2 = new Player();
			int previousLevelPlayer1 = 1;
			int previousLevelPlayer2 = 1;
			
			while((!player1.dead() || !player2.dead()) && controlExecution) {
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