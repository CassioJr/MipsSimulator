package processador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class processadorController {
	@FXML
	private ImageView redArrow,blueArrow,blueArrow2,blueArrow3,purpleArrow,purpleArrow2,brownArrow;
	@FXML
	private TextField n1;
	@FXML
	private TextField n2;
	@FXML
	private Label resultado;
	@FXML
	private Rectangle p,s,b,e,t,k;
	@FXML
	private Pane r ,c,f;
	int resultadoFinal;
	public void resetaFlechas() {
		redArrow.setVisible(false);
		blueArrow.setVisible(false);
		blueArrow2.setVisible(false);
		blueArrow3.setVisible(false);
		purpleArrow.setVisible(false);
		purpleArrow2.setVisible(false);
		brownArrow.setVisible(false);
	}
	public void soma() {
		try {
		resetaFlechas();
		int num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		resultadoFinal = num1+num2;
		c.setVisible(true);
		blueArrow.setVisible(true);
		blueArrow2.setVisible(true);
		blueArrow3.setVisible(true);
		}catch(Exception e) {
			MSA("Digite algum numero para Somar!");
		}
	}
	
	public void sub() {
		try {
		resetaFlechas();
		int num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		resultadoFinal = num1-num2;
		c.setVisible(true);
		redArrow.setVisible(true);
		}catch(Exception e) {
			MSA("Digite algum numero para Subtrair!");
		}
	}
	
	public void mult() {
		try {
		resetaFlechas();
		int num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		resultadoFinal = num1*num2;
		c.setVisible(true);
		purpleArrow.setVisible(true);
		purpleArrow2.setVisible(true);
		}catch(Exception e) {
			MSA("Digite algum numero para Multiplicar!");
		}
		}
	
	public void div() {
		try {
		resetaFlechas();
		int num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		resultadoFinal = num1/num2;
		c.setVisible(true);
		brownArrow.setVisible(true);
		}catch(Exception e) {
			MSA("Digite algum numero para Dividir!");
		}
	}
	public void acaobotao() {
		try {
			
			r.setVisible(true);
			}catch(Exception e) {
				MSA("Digite algum numero para Dividir!");
			}
	
		
	}
	public void result() {
		f.setVisible(true);
		resultado.setText(String.valueOf(resultadoFinal));
	}
	
	public void MSA (String k){
		Alert alert = new Alert (AlertType.WARNING);
		alert.setTitle("Atenção");
		alert.setContentText(k);
		alert.setHeaderText(null);
		alert.showAndWait();
		
		}
	
}
