package hu.unideb.inf.prt.tetris.view.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static String player = "Anonymous";
	public static int score = 0;

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuFXML.fxml"));

		Scene scene = new Scene(root);

		stage.setTitle("Tetris");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
