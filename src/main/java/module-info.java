module mathbrain.maven {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens mathbrain.maven.game to javafx.fxml;
    exports mathbrain.maven.game;
}