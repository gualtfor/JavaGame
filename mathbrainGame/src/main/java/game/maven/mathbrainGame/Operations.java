package game.maven.mathbrainGame;

import java.util.Random;
import javafx.util.Pair;

// 

/**
 * Esta clase representa un modelo de las siguientes clases que se van a realizar.
 * Alli se tiene los atributos y los metodos que van a tener las siguientes clases.
 * 
 * Metodo assessment representa el calculo y la generación del problema
 * 
 * @param problem representacion grafica del problema ej: 2 + 2
 * @param solution valor entero que representa la solucion al problema
 */
abstract class Operations {
	protected String problem;
	protected int solution;
	Random random = new Random();
	
	protected abstract Pair<String, Integer> assessment(int aleatory);
	
}
/**
 * Esta clase genera el problema y la sulución para un problema de suma.
 * Metodo assessment.
 * 
 * @param aleatory Es una número entero aleatorio que sera utilizado para generar una operación aleatoria..
 * @return El resultado esperado es una tupla con la descripción del problema ej: 2 + 2 y la solucion 4
 */
class Addition extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + (int)random.nextInt(50);
		int number2 = (int)(random.nextInt(100)) + 1;
		solution = number1 + number2;
		problem = "" + number1 + "+" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

/**
 * Esta clase genera el problema y la sulucion para un problema de resta.
 * Metodo assessment.
 * 
 * @param aleatory es una numero entero aleatorio que sera utilizado para generar una operacion aleatoria
 * @return El resultado esperado es una tupla con la descripción del problema ej: 2 - 2 y la solucion 0
 */
class Subtraction extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + (int)random.nextInt(50);
		int number2 = (int)(random.nextInt(100)) + 1;
		solution = number1 - number2;
		problem = "" + number1 + "-" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

/**
 * Esta clase genera el problema y la sulucion para un problema de multiplicacion.
 * Metodo assessment.
 * 
 * @param aleatory Es una numero entero aleatorio que sera utilizado para generar una operación aleatoria.
 * @return El resultado esperado es una tupla con la descripción del problema ej: 2 * 2 y la solucion 4
 */
class Multiplication extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + (int)random.nextInt(50);
		int number2 = (int)(random.nextInt(30)) + 1;
		solution = number1 * number2;
		problem = "" + number1 + "*" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

/**
 * Esta clase genera el problema y la sulucion para un problema de division.
 * Metodo assessment.
 * 
 * @param aleatory es una numero entero aleatorio que sera utilizado para generar una operacion aleatoria
 * @return El resultado esperado es una tupla con la descripción del problema ej: 2 / 2 y la solucion 1
 */
class Division extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + (int)random.nextInt(50);
		int number2 = (int)random.nextInt(31) + 1;
		solution = Math.round(number1 / number2);
		problem = "" + number1 + "/" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

/**
 * Esta clase genera el problema y la sulucion para un problema de suma un poco más complejo.
 * Metodo assessment.
 * 
 * @param aleatory es una numero entero aleatorio que sera utilizado para generar una operacion aleatoria
 * @return El resultado esperado es una tupla con la descripción del problema ej: 10 + 2 y la solucion 12
 */
class DifficultAddition extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + (int)random.nextInt(50);
		int number2 = (int)random.nextInt(200) + 1;
		solution = number1 + number2;
		problem = "" + number1 + "+" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}

/**
 * Esta clase genera el problema y la sulucion para un problema de multiplicacion un poco más complejo.
 * Metodo assessment.
 * 
 * @param aleatory es una numero entero aleatorio que sera utilizado para generar una operacion aleatoria
 * @return El resultado esperado es una tupla con la descripción del problema ej: 20 * 2 y la solucion 40
 */
class DifficultMultiplication extends Operations {
	protected Pair<String, Integer> assessment(int aleatory) {
		int number1 = aleatory + (int)random.nextInt(50);
		int number2 = (int)random.nextInt(50) + 1;
		solution = number1 * number2;
		problem = "" + number1 + "*" + number2;
		return new Pair<String, Integer>(problem, solution);
	}
}
