package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @FXML
    private TextField firstnameTextField;

    @FXML
    private CheckBox termsAndConditionsCheckbox;

    @FXML
    private Button signupButtonSignup;

    @FXML
    private Hyperlink privacyPolicy;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private PasswordField confirmPasswordTextField;

    @FXML
    private Hyperlink loginRedirection;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField emailTextField;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        signupButtonSignup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    String dbURL = "jdbc:sqlserver://SASK1A\\SQLEXPRESS:1433;database=InventoryManager";
                    String user = "root";
                    String SQLpassword = "root";
                    String firstname = firstnameTextField.getText().trim();
                    String lastname = lastnameTextField.getText().trim();
                    String username = usernameTextField.getText().trim();
                    String password = passwordTextField.getText().trim();
                    String email = emailTextField.getText().trim();
                    String confirmPassword = confirmPasswordTextField.getText().trim();

                    if (termsAndConditionsCheckbox.isSelected()) {
                        System.out.println("Agreed to terms");
                    }
                    if (confirmPassword == password) {
                        System.out.println("Password matches");
                    } else {
//                        JOptionPane.showMessageDialog(null, "Password doesnt match");
                    }

                    Connection connection = DriverManager.getConnection(dbURL, user, SQLpassword);
                    System.out.println("Connected");

                    String sql = "insert into UserDetails values (?, ?, ?, ?, ?)";
                    PreparedStatement stmts = connection.prepareStatement(sql);
                    stmts.setString(1,firstname);
                    stmts.setString(2,lastname);
                    stmts.setString(3,username);
                    stmts.setString(4,password);
                    stmts.setString(5,email);

                    stmts.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Signed In, Now login to your account");

                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                    primaryStage.setTitle("Billing System");
                    primaryStage.setScene(new Scene(root, 1366, 768));
                    primaryStage.setResizable(false);
                    primaryStage.getIcons().add(new Image("https://i.imgur.com/b0s2e6S.png"));
                    primaryStage.show();
                    Stage stage = (Stage) signupButtonSignup.getScene().getWindow();
                    stage.close();



                } catch (SQLException | IOException e) {
                    System.out.println("Not Connected");
                    (e).printStackTrace();
                }
            }
        }
        );

        loginRedirection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                    primaryStage.setTitle("Billing System");
                    primaryStage.setScene(new Scene(root, 1366, 768));
                    primaryStage.setResizable(false);
                    primaryStage.getIcons().add(new Image("https://i.imgur.com/b0s2e6S.png"));
                    primaryStage.show();
                    Stage stage = (Stage) loginRedirection.getScene().getWindow();
                    stage.close();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });
    }
}
