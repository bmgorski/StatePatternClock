package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import application.context.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Simple Clock");

			Clock clockController = new Clock();

			FXMLLoader loader = new FXMLLoader(
					Main.class.getResource("view/ClockView.fxml"));

			BorderPane root = loader.load();

			Scene scene = new Scene(root, 300, 120);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
