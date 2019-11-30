package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.Date;

public class Controller {

    @FXML
    TextArea inputField;

    @FXML
    TextArea dialogField;

    public void send() {
        String s = inputField.getText();
        String orign = dialogField.getText();
        dialogField.setText(orign + "\n" + new Date() +"   "+ s);
        System.out.println(s);
    }
}
