module game.maven {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
	requires org.apache.logging.log4j;
    opens game.maven.mathbrainGame to javafx.fxml;
    exports game.maven.mathbrainGame;
}