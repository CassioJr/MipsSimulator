package processador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class telaMainController {

	   @FXML
	    void mimps(ActionEvent event) {
		  Stage primaryStage = new Stage();
		   try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("TelaProcessador.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	    @FXML
	    void pipeline(ActionEvent event) {
	    	Stage stage = new Stage();
	    	try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("TelaPipeline.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	    }

	

