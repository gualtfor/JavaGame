package game.maven.mathbrainGame;

import java.util.Random;
import javafx.util.Pair;


abstract class Operations {
	protected String problem;
	protected int solution;
	Random random = new Random();
	
	protected abstract Pair<String, Integer> assessment(int aleatory);
	
}

class Addition extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + 3;
		int number2 = (int)(random.nextInt(18)) + 1;
		solution = number1 + number2;
		problem = "" + number1 + "+" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

class Subtraction extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + 4;
		int number2 = (int)(random.nextInt(18)) + 1;
		solution = number1 + number2;
		problem = "" + number1 + "-" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

class Multiplication extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + 3;
		int number2 = (int)(random.nextInt(19)) + 1;
		solution = number1 * number2;
		problem = "" + number1 + "*" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

class Division extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + 3;
		int number2 = (int)random.nextInt(20) + 1;
		solution = Math.round(number1 / number2);
		problem = "" + number1 + "/" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

class DifficultAddition extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + 3;
		int number2 = (int)random.nextInt(21) + 1;
		solution = number1 + number2;
		problem = "" + number1 + "+" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

class DifficultMultiplication extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + 3;
		int number2 = (int)random.nextInt(21) + 1;
		solution = number1 * number2;
		problem = "" + number1 + "*" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}
