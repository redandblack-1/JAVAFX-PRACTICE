package ContactsApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ContactsApp.Contact;

import java.math.BigDecimal;

public class ContactsAppController {

    @FXML
    private ListView<Contact> contactListView;

    @FXML
    private TextField fNameTextField;

    @FXML
    private TextField lNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField phoneTextField;
    @FXML private TextField genderTextField;


    private final ObservableList<Contact> contacts =
            FXCollections.observableArrayList();


    @FXML
    private void addButtonPressed(ActionEvent event) {
        try {
            if (fNameTextField.getText().equals("") || fNameTextField.getText().equals("fill this field") || lNameTextField.getText().equals("")){
                throw new Exception();
            }
            Contact newOne = new Contact(fNameTextField.getText(), lNameTextField.getText(),
                    (phoneTextField.getText()), emailTextField.getText(), genderTextField.getText());



//            for (Contact i : contacts){
//                if ((i.getFirstName().equals(newOne.getFirstName()) && i.getLastName().equals(newOne.getLastName()))) {
//                    contacts.remove(i);
//                }
//            }
            contacts.removeIf(i -> i.getFirstName().equals(newOne.getFirstName()) && i.getLastName().equals(newOne.getLastName()));

            contacts.add(newOne);

//            if (contacts.contains(newOne)){
//                Contact temp = new Contact();
//                temp.setFirstName(fNameTextField.getText());
//                temp.setLastName(lNameTextField.getText());
//                temp.setPhoneNumber(phoneTextField.getText());
//                temp.setEmail(emailTextField.getText());
//                contacts.set(contacts.indexOf(newOne), temp);
//            }else {
//                contacts.add(newOne);
//            }

            //contacts.set(contacts.indexOf(newOne), newOne);
            contactListView.setItems(contacts);
            fNameTextField.setText("");
            lNameTextField.setText("");
            phoneTextField.setText("");
            emailTextField.setText("");
            genderTextField.setText("");

        }
        catch (Exception ex) {
            fNameTextField.setText("fill in this field");
            lNameTextField.setText("fill in this field");
            phoneTextField.setText("fill in this field");
            emailTextField.setText("fill in this field");
            genderTextField.setText("fill in this field");
        }
    }

    @FXML
    private void deleteButtonPressed(ActionEvent event) {
        try {
            Contact newOne = new Contact(fNameTextField.getText(), lNameTextField.getText(),
                    (phoneTextField.getText()), emailTextField.getText(),genderTextField.getText());

            contacts.removeIf(i -> i.getFirstName().equals(newOne.getFirstName()) && i.getLastName().equals(newOne.getLastName()));
            contactListView.setItems(contacts);
            fNameTextField.setText("");
            lNameTextField.setText("");
            phoneTextField.setText("");
            emailTextField.setText("");
            genderTextField.setText("");

        }
        catch (NumberFormatException ex) {
            fNameTextField.setText("did not find in the directory");
            lNameTextField.setText("did not find in the directory");

        }
    }


    public void initialize() {

        Contact one = new Contact("John", "Wick", "+1989234982398", "john@gmail.com","Male");
        contacts.add(one);

        contactListView.setItems(contacts);


        contactListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<Contact>() {
                            @Override
                            public void changed(ObservableValue<? extends Contact> ov,
                                                Contact oldValue, Contact newValue) {
                                fNameTextField.setText(newValue.getFirstName());
                                lNameTextField.setText(newValue.getLastName());
                                phoneTextField.setText((newValue.getPhoneNumber()));
                                emailTextField.setText(newValue.getEmail());
                                genderTextField.setText(newValue.getGender());

                            }
                        }
                );
    }

}
