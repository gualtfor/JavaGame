package game.maven.mathbrainGame;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import game.maven.mathbrainGame.LogicOfGame;

// Clase donde se realiza el llamado del juego 

/**
 * Clase que contiene la interfaz del juego
 */

public class MathBrain {
	public static void main(String args[]) {
		LogicOfGame init = new LogicOfGame();
		init.beginning();
	}
}
/***
public class MathBrain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css"));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}***/
