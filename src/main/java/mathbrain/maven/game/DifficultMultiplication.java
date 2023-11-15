package mathbrain.maven.game;

public class DifficultMultiplication {
	protected String problem;
	protected int solution;
	
	public Addition() {
		super(.5);
		int number1 = (int)(Math.random() * 30) + 3;
		int number2 = (int)(Math.random() * 25) + 1;
		solution = number1 * number2;
		problem = "" + number1 + "*" + number2;
		radius = 9;
	}
	
	public String getProblem() {
		return problem;
	}
	
	public int getSolution() {
		return solution;
	}

}
