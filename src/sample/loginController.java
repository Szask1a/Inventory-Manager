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
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    @FXML
    private TextField usernameTextField;

    @FXML
    private CheckBox rememberMeCheckbox;

    @FXML
    private Hyperlink forgotPasswordLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Hyperlink privacyPolicy;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = usernameTextField.getText().trim();
                String password = passwordTextField.getText().trim();
                String passwordDatabase = null;
                String usernameDatabase = null;

                String dbURL = "jdbc:sqlserver://SASK1A\\SQLEXPRESS:1433;database=InventoryManager";
                String userSQL = "root";
                String passwordSQL = "root";
                try {
                    Connection connection = DriverManager.getConnection(dbURL, userSQL, passwordSQL);
                    System.out.println("Connected");

                    try {
                        Statement s=connection.createStatement();
                        ResultSet rs=s.executeQuery("SELECT * FROM UserDetails WHERE UserName ='"+username+"' AND UserPassword ='"+password+"' ");

                        while(rs.next())
                        {
                            usernameDatabase = rs.getString("UserName");
                            passwordDatabase =rs.getString("UserPassword");

                        }
                        if(username.equals(usernameDatabase)&& password.equals(passwordDatabase))
                        {
                            JOptionPane.showMessageDialog(null,"Access Granted","Granted",JOptionPane.INFORMATION_MESSAGE);

                            Stage primaryStage = new Stage();
                            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                            primaryStage.setTitle("Billing System");
                            primaryStage.setScene(new Scene(root, 1366, 768));
                            primaryStage.setResizable(false);
                            primaryStage.getIcons().add(new Image("https://i.imgur.com/b0s2e6S.png"));
                            primaryStage.show();
                            Stage stage = (Stage) loginButton.getScene().getWindow();
                            stage.close();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception e){
                        System.out.println(e);
                    }

                } catch (SQLException e) {
                    System.out.println("Not Connected");
                    (e).printStackTrace();
                }
            }
        });

        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //Redirecting to Dashboard starts
                try {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
                    primaryStage.setTitle("Billing System");
                    primaryStage.setScene(new Scene(root, 1366, 768));
                    primaryStage.setResizable(false);
                    primaryStage.getIcons().add(new Image("https://i.imgur.com/b0s2e6S.png"));
                    Stage stage = (Stage) signupButton.getScene().getWindow();
                    stage.close();
                    primaryStage.show();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        forgotPasswordLabel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
                    primaryStage.setTitle("Billing System");
                    primaryStage.setScene(new Scene(root, 1366, 768));
                    primaryStage.setResizable(false);
                    primaryStage.getIcons().add(new Image("https://i.imgur.com/b0s2e6S.png"));
                    Stage stage = (Stage) forgotPasswordLabel.getScene().getWindow();
                    stage.close();
                    primaryStage.show();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });
    }
}
