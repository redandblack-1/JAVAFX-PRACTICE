package sample;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {


    @FXML
    private Button calculateButton;

    @FXML
    private TextField weightMetricTextField;

    @FXML
    private TextField heightMetricTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label remarkLabel;

    @FXML
    private RadioButton metricRadioButton;

    @FXML
    private ToggleGroup unitSelectToggleGroup;

    @FXML
    private RadioButton englishRadioButton;


    @FXML
    void calculateM(ActionEvent event) {
        if (metricRadioButton.isSelected()) {
            try {
                double weightM = Double.parseDouble(weightMetricTextField.getText());
                double heightM = Double.parseDouble(heightMetricTextField.getText());
                double bmiM = 0;
                bmiM = weightM / Math.pow(heightM / 100, 2);
                if (bmiM != 0) {
                    resultLabel.setText("BMI in Metric unit is " + Math.round(bmiM));
                    if (bmiM > 30) {
                        remarkLabel.setText("Obese");
                    } else if (bmiM >= 25 && bmiM <= 29.9) {
                        remarkLabel.setText("Overweight");
                    } else if (bmiM >= 18.5 && bmiM <= 24.9) {
                        remarkLabel.setText("Normal");
                    } else {
                        remarkLabel.setText("Underweight");
                    }
                }
            } catch (NumberFormatException e) {
                weightMetricTextField.setText("0");
                heightMetricTextField.setText("0");
            }
        }else if(englishRadioButton.isSelected()){
            try {
                double weightM = Double.parseDouble(weightMetricTextField.getText());
                double heightM = Double.parseDouble(heightMetricTextField.getText());
                double bmiM = 0;
                bmiM = 703*weightM / Math.pow(heightM, 2);
                if (bmiM != 0) {
                    resultLabel.setText("BMI in English unit is " + Math.round(bmiM));
                    if (bmiM > 30) {
                        remarkLabel.setText("Obese");
                    } else if (bmiM >= 25 && bmiM <= 29.9) {
                        remarkLabel.setText("Overweight");
                    } else if (bmiM >= 18.5 && bmiM <= 24.9) {
                        remarkLabel.setText("Normal");
                    } else {
                        remarkLabel.setText("Underweight");
                    }
                }
            } catch (NumberFormatException e) {
                weightMetricTextField.setText("0");
                heightMetricTextField.setText("0");
            }

        }
    }
}
