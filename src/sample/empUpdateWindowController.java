package sample;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import javax.swing.*;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class empUpdateWindowController implements Initializable {

    @FXML
    private JFXTextField empNameUpdate;

    @FXML
    private JFXTextField empIdUpdate;

    @FXML
    private JFXTextField positionUpdate;

    @FXML
    private JFXTextField branchUpdate;

    @FXML
    private JFXButton updateEmpButton;

    @FXML
    private JFXTextField salaryUpdate;

    @FXML
    private JFXTextField shiftUpdate;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateEmpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    String dbURL = "jdbc:sqlserver://SASK1A\\SQLEXPRESS:1433;database=InventoryManager";
                    String user = "root";
                    String password = "root";
                    String empName = empNameUpdate.getText().trim();
                    String empID = empIdUpdate.getText().trim();
                    String position = positionUpdate.getText().trim();
                    String salaryString = salaryUpdate.getText().trim();
                    Double salary = Double.parseDouble(salaryString);
                    String branch = branchUpdate.getText().trim();
                    String shift = shiftUpdate.getText().trim();

                    Connection connection = DriverManager.getConnection(dbURL, user, password);
                    System.out.println("Connected");
                    String sql = "insert into EmployeeDemographics values (?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmts = connection.prepareStatement(sql);
                    stmts.setString(1,empID);
                    stmts.setString(2,empName);
                    stmts.setString(3,position);
                    stmts.setDouble(4,salary);
                    stmts.setString(5,branch);
                    stmts.setString(6,shift);

                    stmts.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Employee Added");

                    System.out.println(empName);
                    System.out.println(empID);
                    System.out.println(position);
                    System.out.println(salary);
                    System.out.println(branch);
                    System.out.println(shift);

                    Stage stage = (Stage) updateEmpButton.getScene().getWindow();
                    stage.close();
                } catch (SQLException e) {
                    System.out.println("Not Connected");
                    (e).printStackTrace();
                }
            }
        });
    }

}
