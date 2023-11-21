package game.maven.mathbrainGame;

import junit.framework.TestCase;
import javafx.util.Pair;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import game.maven.mathbrainGame.Level;
import game.maven.mathbrainGame.LogicOfGame;
import game.maven.mathbrainGame.Player;

public class LogicOfGameTest extends TestCase {

	public void testCompareAnswersQuestions() {
        LogicOfGame logic = new LogicOfGame();
        Player player = new Player();
        Level level = new Level(player, false);

        Integer[] answers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Pair<String, Integer>> questions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            questions.add(new Pair<>("Question " + (i + 1), i + 1));
        }

        boolean[] checkAnswers = logic.compareAnswersQuestions(answers, questions, player, level);
        assertTrue(Arrays.equals(checkAnswers, new boolean[]{true, true, true, true, true, true, true, true, true, true}));
    }
	
	public void testProcess() {
        Player player = new Player();
        Level level = new Level(player, false);
        LogicOfGame logicOfGame = new LogicOfGame();

        logicOfGame.process("Addition", "Multiplication", 5, player, level);
        assertEquals(10, player.getHealth()); // Assuming 5 good responses, each adds 2 health

        logicOfGame.process("Subtraction", "Multiplication", 5, player, level);
        assertEquals(5, player.getHealth()); // Assuming 5 bad responses, each deducts 1 health
    }
}

