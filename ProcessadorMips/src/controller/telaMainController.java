package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class telaMainController {
		private Stage primaryStage;
	
	   @FXML
	    void mimps(ActionEvent event) {
		  primaryStage = new Stage();
		   try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/telas/TelaProcessador.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	    @FXML
	    void pipeline(ActionEvent event) {
	    	primaryStage = new Stage();
	    	try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/telas/TelaPipeline.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	    }

	

