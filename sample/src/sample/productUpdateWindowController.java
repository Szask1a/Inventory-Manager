package sample;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class productUpdateWindowController implements Initializable {

    @FXML
    private JFXTextField productName;

    @FXML
    private JFXTextField quantity;

    @FXML
    private JFXTextField unitPrice;

    @FXML
    private JFXTextField category;

    @FXML
    private JFXTextArea productDescription;

    @FXML
    private JFXButton updateButton;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String productNameField = productName.getText().trim();
                String productDescriptionField = productDescription.getText().trim();
                String quantityField = quantity.getText().trim();
                String unitPriceField = unitPrice.getText().trim();
                String categoryField = category.getText().trim();
                System.out.println(productNameField);
                System.out.println(productDescriptionField);
                System.out.println(quantityField);
                System.out.println(unitPriceField);
                System.out.println(categoryField);

                Stage stage = (Stage) updateButton.getScene().getWindow();
                stage.close();
            }
        });
    }

}
