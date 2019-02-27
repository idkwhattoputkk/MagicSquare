package userInterface;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.MagicSquare;

public class ControlAMagicSquare {
	MagicSquare ms;

	@FXML
	private BorderPane ac;

	@FXML
	private TextField txt1;
	@FXML
	private Label lblC;

	private GridPane grd1;

	@FXML
	private ComboBox<String> positions;

	@FXML
	private ComboBox<String> orientations;
	
	public void controlTheMagicSquare(ActionEvent event){
		try {
		int num = Integer.parseInt(txt1.getText());
		ms.setX(num);
		ms.createMagicSquare(positions.getValue(),orientations.getValue());
		printMatrix();
		} catch(Exception ex) {
			String msg = ex.getMessage();
			JOptionPane.showMessageDialog(null, msg);
		}
	}

	public void initialize() {
		ms = new MagicSquare();
		positions.getItems().addAll("UP", "DOWN", "RIGHT", "LEFT");
		orientations.getItems().addAll("NO", "NE", "SO", "SE");
	}

	public void printMatrix() {

		grd1 = new GridPane();

		for (int i = 0; i < ms.getX(); i++) {
			for (int j = 0; j < ms.getX(); j++) {
				Button b = new Button();
				b.setText("" + ms.getMatrix()[i][j] + "");
				b.setPrefWidth(50);
				grd1.add(b, i, j);
			}
		}
		grd1.setAlignment(Pos.CENTER);
		ac.setCenter(grd1);
		lblC.setText("Magic Constant: " + ms.magicConstant() + "");
	}
}

