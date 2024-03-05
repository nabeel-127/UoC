package uoc.sdt.challenge_exercises;

import java.io.IOException;
// import javafx.beans.binding.Bindings;
// import javafx.beans.binding.IntegerBinding;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
// import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Color;
// import javafx.util.converter.IntegerStringConverter;

public class Controller {
	ChesterInsurance myData = new ChesterInsurance();
	boolean vehicleSelected = false;

	@FXML
	private RadioButton carRadioButton;
	@FXML
	private RadioButton motorcycleRadioButton;
	@FXML
	private CheckBox under25CheckBox;
	@FXML
	private TextField pointsTextField;
	@FXML
	private Label outputA;
	@FXML
	private Label outputB;

	public void initialize() {
		
	}

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

	@FXML
	private void selectCar() throws IOException {
		if (carRadioButton.isSelected()) {
			myData.setVehicle("Car");
		}
		motorcycleRadioButton.setSelected(false);
	}
	
	@FXML
	private void selectMotorcycle() throws IOException {
		if (motorcycleRadioButton.isSelected()) {
			myData.setVehicle("Motorcycle");
		}
		carRadioButton.setSelected(false);
	}

	@FXML
	private void under25() {
		if (under25CheckBox.isSelected()) {
			myData.under25(true);
		} else {
			myData.under25(false);
		}
	}

	@FXML
	private void submit() {
		outputA.setText("");
		outputA.setTextFill(Color.WHITE);
		outputB.setText("");
		outputB.setTextFill(Color.WHITE);
		if ((carRadioButton.isSelected() || motorcycleRadioButton.isSelected()) && myData.pointsIsValid(pointsTextField.getText())) {
			displayText("Your total premium is " + myData.getTotalPremium());
		} else {
			outputA.setTextFill(Color.RED);
			outputB.setTextFill(Color.RED);
		}
		if (!(carRadioButton.isSelected() || motorcycleRadioButton.isSelected())) {
			displayText("Please select a vehicle type\n");
		}
		if (pointsTextField.getText().isEmpty()) {
			displayText("Please enter the number of points");
		} else if (!myData.pointsIsValid(pointsTextField.getText())) {
			displayText("Invalid entry");
		}
	}

	private void displayText(String output) {
		if (outputA.getText() == "")
			outputA.setText(output);
		else
			outputB.setText(output);
	}
}