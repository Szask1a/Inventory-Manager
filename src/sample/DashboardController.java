package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.products;

import com.jfoenix.controls.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DashboardController implements Initializable{

    @FXML
    private Hyperlink settingsRedirect;

    @FXML
    private Hyperlink dashboardRedirect;

    @FXML
    private Hyperlink empRedirect;

    @FXML
    private Hyperlink invoiceRedirect;

    @FXML
    private AnchorPane invoicesTab;

    @FXML
    private TableView<products> table;

    @FXML
    private TableColumn<products, String> productCodeColumn;

    @FXML
    private TableColumn<products, String> productNameColumn;

    @FXML
    private TableColumn<products, Double> unitPriceColumn;

    @FXML
    private TableColumn<products, Double> stockAvailabilityColumn;

    @FXML
    private TableColumn<products, String> productCategoryColumn;

    @FXML
    private TableColumn<products, String> totalColumn;

    @FXML
    private JFXTextField customerNameInvoice;

    @FXML
    private JFXButton printButtonInvoice;

    @FXML
    private JFXTextField orderNoInvoice;

    @FXML
    private JFXTextField CustomerNumberInvoice;

    @FXML
    private JFXTextField DOD;

    @FXML
    private JFXTextField orderDateInoivce;

    @FXML
    private JFXButton addProductButton;

    @FXML
    private JFXTextField productNameInput;

    @FXML
    private JFXTextField unitPriceInput;

    @FXML
    private JFXTextField quantityInput;

    @FXML
    private JFXTextField productCodeInput;

    @FXML
    private JFXTextField categoryInput;

    @FXML
    private JFXTextArea productDescriptionInput;

    @FXML
    private AnchorPane settingsTab;

    @FXML
    private Hyperlink signinRedirect;

    @FXML
    private Hyperlink changePasswordRedirect;

    @FXML
    private Hyperlink resetPassword;

    @FXML
    private Hyperlink logoutRedirect;

    @FXML
    private AnchorPane empTab;

    @FXML
    private TableView<employees> updateTable;

    @FXML
    private TableColumn<employees, String> empIDColumn;

    @FXML
    private TableColumn<employees, String> empNameColumn;

    @FXML
    private TableColumn<employees, String> positionColumn;

    @FXML
    private TableColumn<employees, String> branchColumn;

    @FXML
    private TableColumn<employees, Double> salaryColumn;

    @FXML
    private TableColumn<employees, String> shiftColumn;

    @FXML
    public JFXButton addEmployeeButton;

    @FXML
    private JFXButton searchEmployeeButton;

    @FXML
    private JFXTextField searchEmployeeField;

    @FXML
    private AnchorPane dashboardTab;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String dbURL = "jdbc:sqlserver://SASK1A\\SQLEXPRESS:1433;database=InventoryManager";
        String user = "root";
        String password = "root";
        ObservableList<employees> empList = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection(dbURL, user, password);
            System.out.println("Connected");

            String query = "Select * from EmployeeDemographics";
            ResultSet set = connection.createStatement().executeQuery(query);

            while (set.next()) {
                empList.add(
                        new employees(
                                set.getString("EmpID"),
                                set.getString("EmpName"),
                                set.getString("Position"),
                                set.getDouble("Salary"),
                                set.getString("Branch"),
                                set.getString("ShiftTime")
                        )
                );
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        empIDColumn.setCellValueFactory(new PropertyValueFactory<>("EmpID"));
        empNameColumn.setCellValueFactory(new PropertyValueFactory<>("EmpName"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("Position"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        branchColumn.setCellValueFactory(new PropertyValueFactory<>("Branch"));
        shiftColumn.setCellValueFactory(new PropertyValueFactory<>("ShiftTime"));
        updateTable.setItems(empList);

        addProductButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    String dbURL = "jdbc:sqlserver://SASK1A\\SQLEXPRESS:1433;database=InventoryManager";
                    String user = "root";
                    String password = "root";
                    String productName = productNameInput.getText().trim();
                    String productCode = productCodeInput.getText().trim();
                    String quantityString = quantityInput.getText().trim();
                    Double quantity = Double.parseDouble(quantityString);
                    String unitPriceString = unitPriceInput.getText().trim();
                    Double unitPrice = Double.parseDouble(unitPriceString);
                    String productCategory = categoryInput.getText().trim();
                    String productDescription = productDescriptionInput.getText().trim();
                    String orderNO = orderNoInvoice.getText().trim();
                    String customerName = customerNameInvoice.getText().trim();
                    String custmerNum = CustomerNumberInvoice.getText().trim();
                    String dod = DOD.getText().trim();
                    String orderDate = orderDateInoivce.getText().trim();
                    Double total = unitPrice * quantity;

                    ObservableList<products> cartList = (ObservableList<products>) FXCollections.observableArrayList(
                            new products(
                                    productCode,
                                    productName,
                                    unitPrice,
                                    quantity,
                                    productCategory,
                                    total
                            )
                    );

                    Connection connection = DriverManager.getConnection(dbURL, user, password);
                    System.out.println("Connected");

                    String sql = "insert into CartItems values (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmts = connection.prepareStatement(sql);
                    stmts.setString(1, orderNO);
                    stmts.setString(2,productName);
                    stmts.setString(3,productDescription);
                    stmts.setString(4,productCategory);
                    stmts.setString(5,productCode);
                    stmts.setDouble(6,unitPrice);
                    stmts.setDouble(7,quantity);


                    String sql1 = "insert into Invoices values (?, ?, ?, ?, ?)";
                    PreparedStatement stmts1 = connection.prepareStatement(sql1);
                    stmts1.setString(1, customerName);
                    stmts1.setString(2,custmerNum);
                    stmts1.setString(3,dod);
                    stmts1.setString(4,orderDate);
                    stmts1.setString(5,orderNO);

                    productCodeColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
                    productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
                    unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
                    stockAvailabilityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                    productCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
                    totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
                    table.setItems(cartList);

                    stmts.executeUpdate();
                    stmts1.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Product Added");



                } catch (SQLException e) {
                    System.out.println("Not Connected in Dashboard");
                    (e).printStackTrace();
                }
            }
        });

        printButtonInvoice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String customerName = customerNameInvoice.getText().trim();
                String custmerNum = CustomerNumberInvoice.getText().trim();
                String orderNo = orderNoInvoice.getText().trim();
                String dod = DOD.getText().trim();
                String orderDate = orderDateInoivce.getText().trim();
                System.out.println(custmerNum);
                System.out.println(customerName);
                System.out.println(orderDate);
                System.out.println(orderNo);
                System.out.println(dod);
            }
        });

        settingsRedirect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                empTab.setVisible(false);
                settingsTab.setVisible(true);
                invoicesTab.setVisible(false);
                dashboardTab.setVisible(false);
            }
        });

        dashboardRedirect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                empTab.setVisible(false);
                settingsTab.setVisible(false);
                invoicesTab.setVisible(false);
                dashboardTab.setVisible(true);
            }
        });

        empRedirect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                empTab.setVisible(true);
                settingsTab.setVisible(false);
                invoicesTab.setVisible(false);
                dashboardTab.setVisible(false);
            }
        });

        invoiceRedirect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                empTab.setVisible(false);
                settingsTab.setVisible(false);
                invoicesTab.setVisible(true);
                dashboardTab.setVisible(false);
            }
        });

        addEmployeeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("empUpdateWindow.fxml"));
                    primaryStage.setTitle("Billing System");
                    primaryStage.setScene(new Scene(root, 400, 600));
                    primaryStage.setResizable(false);
                    primaryStage.getIcons().add(new Image("https://i.imgur.com/b0s2e6S.png"));
                    primaryStage.show();
                } catch (Exception e){
                    System.out.println(e);

                }
            }
        });

        logoutRedirect.setOnAction(new EventHandler<ActionEvent>() {
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
                } catch (Exception e){
                    System.out.println(e);

                }
            }
        });

        signinRedirect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
                    primaryStage.setTitle("Billing System");
                    primaryStage.setScene(new Scene(root, 1366, 768));
                    primaryStage.setResizable(false);
                    primaryStage.getIcons().add(new Image("https://i.imgur.com/b0s2e6S.png"));
                    primaryStage.show();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        resetPassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
                    primaryStage.setTitle("Billing System");
                    primaryStage.setScene(new Scene(root, 1366, 768));
                    primaryStage.setResizable(false);
                    primaryStage.getIcons().add(new Image("https://i.imgur.com/b0s2e6S.png"));
                    primaryStage.show();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });
    }
}


