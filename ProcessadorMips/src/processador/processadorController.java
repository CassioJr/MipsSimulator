package processador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class processadorController {
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
	
	public void soma() {
		try {
		int num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		resultadoFinal = num1+num2;
		c.setVisible(true);
		}catch(Exception e) {
			MSA("Digite algum numero para Somar!");
		}
	}
	
	public void sub() {
		try {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		resultadoFinal = num1-num2;
		c.setVisible(true);
		}catch(Exception e) {
			MSA("Digite algum numero para Subtrair!");
		}
	}
	
	public void mult() {
		try {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		resultadoFinal = num1*num2;
		c.setVisible(true);
		}catch(Exception e) {
			MSA("Digite algum numero para Multiplicar!");
		}
		}
	
	public void div() {
		try {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		resultadoFinal = num1/num2;
		c.setVisible(true);
		}catch(Exception e) {
			MSA("Digite algum numero para Dividir!");
		}
	}
	public void acaobotao() {
		r.setVisible(true);
		
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
