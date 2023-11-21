module game.maven {
    opens game.maven.mathbrainGame to javafx.fxml;
    exports game.maven.mathbrainGame;
	requires org.apache.logging.log4j;
	requires javafx.base;
	requires javafx.graphics;
}

// This file is problematic when you want to create the javadoc always delete this file when you do this process