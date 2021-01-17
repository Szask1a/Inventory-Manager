package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public SignupController(){
        con = DBConnect.ConnectDB();
    }

    @FXML
    private TextField firstnameTextField;

    @FXML
    private CheckBox termsAndConditionsCheckbox;

    @FXML
    private Button signupButtonSignup;

    @FXML
    private Label privacyPolicy;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private PasswordField confirmPasswordTextField;

    @FXML
    private Label loginRedirection;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField emailTextField;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        signupButtonSignup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String firstname = firstnameTextField.getText().trim();
                String lastname = lastnameTextField.getText().trim();
                String username = usernameTextField.getText().trim();
                String password = passwordTextField.getText().trim();
                String email = emailTextField.getText().trim();
                String confirmPassword = confirmPasswordTextField.getText().trim();
                System.out.println(firstname);
                System.out.println(lastname);
                System.out.println(username);
                System.out.println(password);
                System.out.println(confirmPassword);
                System.out.println(email);

                if (firstname.compareTo("")==0){
                    JOptionPane.showMessageDialog(null, "First Name not entered");
                }
                if (lastname.compareTo("")==0){
                    JOptionPane.showMessageDialog(null, "Last Name not entered");
                }
                if (username.compareTo("")==0){
                    JOptionPane.showMessageDialog(null, "Username not entered");
                }
                if (password.compareTo("")==0){
                    JOptionPane.showMessageDialog(null, "Password not entered");
                }
                if (confirmPassword.compareTo("")==0){
                    JOptionPane.showMessageDialog(null, "Password not entered");
                }
                if (email.compareTo("")==0){
                    JOptionPane.showMessageDialog(null, "email not entered");
                }
                else
                    try{
                        Statement stmt = con.createStatement();

                      //  String sql = "insert into user(username,password,firstname,lastname,email)"+"values('"+username+"','"+password+",'"+firstname+",'"+lastname+",,'"+email+"')";
                        String sql = "insert into user values(?,?,?,?,?)";
                        PreparedStatement stmts=con.prepareStatement(sql);
                        stmts.setString(1,username);
                        stmts.setString(2,password);
                        stmts.setString(3,firstname);
                        stmts.setString(4,lastname);
                        stmts.setString(5,email);

                        stmts.executeUpdate();

                        //stmt.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "User Sign Up Complete");
                        System.out.println("COrrect");
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Something went wrong","Error",JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(e);
                    }
                firstnameTextField.setText("");
                lastnameTextField.setText("");
                usernameTextField.setText("");
                passwordTextField.setText("");
                emailTextField.setText("");
                confirmPasswordTextField.setText("");




                if (termsAndConditionsCheckbox.isSelected()) {
                    System.out.println("Agreed to terms");
                }
            }
        });
    }
}
