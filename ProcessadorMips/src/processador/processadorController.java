package processador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class processadorController {
	@FXML
	private TextField n1;
	@FXML
	private TextField n2;
	@FXML
	private Label resultado;
	@FXML
	private Circle p;
	@FXML
	private Circle s;
	@FXML
	private Line bet;
	
	public void soma() {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		result = num1+num2;
		resultado.setText(String.valueOf(result));
	}
	
	public void sub() {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		result = num1-num2;
		resultado.setText(String.valueOf(result));
	}
	
	public void mult() {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		result = num1*num2;
		resultado.setText(String.valueOf(result));
	}
	
	public void div() {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		result = num1/num2;
		resultado.setText(String.valueOf(result));
	}
	public void acaobotao() {
		p.setVisible(true);
		s.setVisible(true);
		bet.setVisible(true);
	}
	
}
