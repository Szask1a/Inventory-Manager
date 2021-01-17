package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ForgetPasswordController implements Initializable {

    @FXML
    private TextField emailTextField;

    @FXML
    private Button sendRequestButton;

    @FXML
    private Label privacyPolicy;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sendRequestButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email = emailTextField.getText().trim();
                System.out.println(email);
            }
        });
    }
}
