/**
 * Prosta gra w 15 wykonana w javafx
 * pierwsza aplikacja w tej bibliotece
 * @author Rafcio
 */
package com.rafalspr.oknofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class kurs1 extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	/*	StackPane stackPane = new StackPane();
		Button button = new Button("Przycisk");
		stackPane.getChildren().add(button);
		Scene scene = new  Scene(stackPane, 400, 400);	
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.DECORATED);
		*/
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("StackPaneWindow.fxml"));
	
		//StackPaneController controler = new StackPaneController();
		//loader.setController(controler);
		
		StackPane stackPane = loader.load();
		
		Scene scene = new Scene(stackPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Gra w 15");
		//scene.getStylesheets().add(StackPaneController.class.getResource("style.css").toExternalForm());
		primaryStage.show();
		
	}

}
