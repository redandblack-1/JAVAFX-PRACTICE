package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class Controller {
    private static final NumberFormat currency= NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent=NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage=new BigDecimal(0.15);

    @FXML
    private Label amountLabel;

    @FXML
    private Label percentageLabel;

    @FXML
    private Label tipLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private Slider percentSlider;

    @FXML
    private Button button;

    @FXML
    private TextField numberPeopleTextField;
    @FXML
    private TextField perPersonTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{
            BigDecimal amount=new BigDecimal(amountTextField.getText());
            BigDecimal totalUsers = new BigDecimal(numberPeopleTextField.getText());
            BigDecimal tip=amount.multiply(tipPercentage);
            BigDecimal total=amount.add(tip);
            BigDecimal totalPerHead = total.divide(totalUsers);

            tipTextField.setText(currency.format(tip));
            perPersonTextField.setText(currency.format(totalPerHead));
            totalTextField.setText(currency.format(total));

        }
        catch (NumberFormatException ex) {
            amountTextField.setText("Enter amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }


    }
    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);

        percentSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        tipPercentage=BigDecimal.valueOf(newValue.intValue() / 100.0);
                        percentageLabel.setText(percent.format(tipPercentage));
                    }
                  }


        );
    }

}