package mathbrain.maven.game;

public class Subtraction {
	protected String problem;
	protected int solution;
	
	public Addition() {
		super(.5);
		int number1 = (int)(Math.random() * 8) + 3;
		int number2 = (int)(Math.random() * 11) + 1;
		solution = number1 + number2;
		problem = "" + number1 + "-" + number2;
	}
	
	public String getProblem() {
		return problem;
	}
	
	public int getSolution() {
		return solution;
	}
}
