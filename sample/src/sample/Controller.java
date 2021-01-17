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

public class Controller implements Initializable {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Controller(){

        con= DBConnect.ConnectDB();
    }
    @FXML
    private TextField usernameTextField;

    @FXML
    private CheckBox rememberMeCheckbox;

    @FXML
    private Label forgotPasswordLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Label privacyPolicy;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = usernameTextField.getText().trim();
                String password = passwordTextField.getText().trim();
                System.out.println(username);
                System.out.println(password);

                if(username.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please Enter Your Username");
                }
                else if(password.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please Enter Your Password");
                }
                try
                {


                    String usernamedb=null;
                    String passworddb=null;


                    Statement s=con.createStatement();
                    ResultSet rs=s.executeQuery("SELECT * FROM user WHERE username ='"+username+"' AND password ='"+password+"' ");

                    while(rs.next())
                    {
                        usernamedb=rs.getString("username");
                        passworddb=rs.getString("password");

                        System.out.println(usernamedb);
                        System.out.println(passworddb);

                    }
                    if(username.equals(usernamedb)&& password.equals(passworddb))
                    {
                        System.out.println("Correct");
                       // JOptionPane.showMessageDialog(null,"Access Granted","Granted",JOptionPane.INFORMATION_MESSAGE);
                      //  setVisible(false);
                       //  Dashboard ShowDash = new Dashboard();

                      //  ShowDash.setVisible(true);

                        //ShowDash.user(usernamedb);
                    }
                    else
                    {
                      //  JOptionPane.showMessageDialog(null,"Access Denied","Denied",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }




                if (rememberMeCheckbox.isSelected()) {
                    System.out.println("Remember Login Details");
                }
            }
        });
    }
}
