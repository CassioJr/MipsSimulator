package processador;

import javafx.fxml.FXML;
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
	private Pane r ,c;
	
	
	public void soma() {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		result = num1+num2;
		resultado.setText(String.valueOf(result));
		c.setVisible(true);
		
	}
	
	public void sub() {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		result = num1-num2;
		resultado.setText(String.valueOf(result));
		c.setVisible(true);
	}
	
	public void mult() {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		result = num1*num2;
		resultado.setText(String.valueOf(result));
		c.setVisible(true);
	}
	
	public void div() {
		int result,num1,num2;
		num1 = Integer.parseInt(n1.getText());
		num2 = Integer.parseInt(n2.getText());
		result = num1/num2;
		resultado.setText(String.valueOf(result));
		c.setVisible(true);
	}
	public void acaobotao() {
		r.setVisible(true);
		
	}
	
}
