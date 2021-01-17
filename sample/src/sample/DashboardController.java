package sample;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;


//import net.proteanit.sql.DbUtils;


import java.net.URL;
import java.sql.*;

import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import static javafx.scene.control.cell.TextFieldTableCell.forTableColumn;

public class DashboardController implements Initializable{
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    public DashboardController(){
        con = DBConnect.ConnectDB();
    }



//    public void Update_table(String x){
//        try{
//            String query = (x);
//            PreparedStatement pst = con.prepareStatement(query);
//            ResultSet rs=pst.executeQuery();
//
//
//           table.setModel(DbUtils.resultSetToTableModel(rs));
//
//            pst.close();
//            rs.close();
//
//
//
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//    }

//    private ObservableList<products> datalist = FXCollections.observableArrayList();

    private ObservableList<products> list;
    private DBConnect dbconnect;

    @FXML
    private Hyperlink settingsRedirect;

    @FXML
    private Hyperlink dashboardRedirect;

    @FXML
    private Hyperlink invoiceRedirect;

    @FXML
    private Hyperlink productRedirect;

    @FXML
    private AnchorPane productsTab;

    @FXML
    private TableView<products> table;

    @FXML
    private TableColumn<products, String> productCode;

    @FXML
    private TableColumn<products, String> productName;

    @FXML
    private TableColumn<products, Double> unitPrice;

    @FXML
    private TableColumn<products, Double> stockAvailability;

    @FXML
    private TableColumn<products, String> productCategory;

    @FXML
    private TableColumn buttonColumn;
    @FXML
    private TableColumn buttonColumninvoice;

    @FXML
    private JFXButton searchProductQueryButton;

    @FXML
    private JFXTextField searchProductQueryInput;
    @FXML
    private JFXTextField quantityinvoice;

    @FXML
    private JFXTextField billnumber;

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
    private AnchorPane invoicesTab;

    @FXML
    private Label invoiceDate;

    @FXML
    private JFXTextField customerName;

    @FXML
    private Label orderNumber;

    @FXML
    private TableView<products> updateTable;

    @FXML
    private TableColumn<products, String> invoicePcode;

    @FXML
    private TableColumn<products, String> invoicePname;

    @FXML
    private TableColumn<products, String> invoicePquantity;

    @FXML
    private TableColumn<products, Double> invoicePunitprice;

    @FXML
    private TableColumn<products, Double> invoicePtotal;

    @FXML
    private JFXButton printButton;

    @FXML
    private AnchorPane dashboardTab;

    @FXML
    private JFXButton editProductButton;

    @FXML
    private JFXButton addProductButtonInvoice;

    @FXML
    private JFXTextField searchProductField;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {



        populatetableonsearch();
        //invoiceadd();


        //Search
//        productCodeColumn.setCellValueFactory(new PropertyValueFactory<>("productcode"));
//        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productname"));
//        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//        stockAvailabilityColumn.setCellValueFactory(new PropertyValueFactory<>("stockavailable"));
//        productCategory.setCellValueFactory(new PropertyValueFactory<>("category"));



//        FilteredList<products> filtereddata = new FilteredList<>(datalist, b-> true);
//
//        searchProductQueryInput.textProperty().addListener((observable, oldValue, newValue) -> {
//            filtereddata.setPredicate(products -> {
//                if(newValue == null || newValue.isEmpty() ){
//                    return true;
//                }
//
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if(products.getProductname().toLowerCase().indexOf(lowerCaseFilter) != -1){
//                    return true;
//                }
//                else if(products.getProductcode().toLowerCase().indexOf(lowerCaseFilter) != -1){
//                    return true;
//                }else
//                    return false;
//            });
//        });
//        SortedList<products> sortedData = new SortedList<>(filtereddata);
//        sortedData.comparatorProperty().bind(table.comparatorProperty());
//
//        table.setItems(sortedData);




        addProductButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String productName = productNameInput.getText().trim();
                String productCode = productCodeInput.getText().trim();
                String quantity = quantityInput.getText().trim();
                String unitPrice = unitPriceInput.getText().trim();
                String productCategory = categoryInput.getText().trim();
                String productDescription = productDescriptionInput.getText().trim();
                String searchQuery = searchProductQueryInput.getText().trim();
                System.out.println(productCode);
                System.out.println(productName);
                System.out.println(quantity);
                System.out.println(unitPrice);
                System.out.println(productCategory);
                System.out.println(productDescription);
                System.out.println(searchQuery);

                if (productName.compareTo("")==0){
                    JOptionPane.showMessageDialog(null,"Please Enter");
                }
                if (productCode.compareTo("")==0){
                    JOptionPane.showMessageDialog(null,"Please Enter");
                }
                if (unitPrice.compareTo("")==0){
                    JOptionPane.showMessageDialog(null,"Please Enter");
                }
                if (productCategory.compareTo("")==0){
                    JOptionPane.showMessageDialog(null,"Please Enter");
                }
                if (quantity.compareTo("")==0){
                    JOptionPane.showMessageDialog(null,"Please Enter");
                }
                if (productDescription.compareTo("")==0){
                    JOptionPane.showMessageDialog(null,"Please Enter");
                }

                else
                    try{

                        Statement stmt = con.createStatement();
//                        String sql = "insert into products(productcode,productname,unitprice,quantity,category,description)"+"values('"+productCode+"','"+productName+"','"+unitPrice+"','"+quantity+",'"+productCategory+",'"+productDescription+"')";
//                        stmt.executeUpdate(sql);
                        String sql = "insert into products values(?,?,?,?,?,?)";

                        PreparedStatement stmts=con.prepareStatement(sql);
                        stmts.setString(1,productCode);
                        stmts.setString(2,productName);
                        stmts.setString(3,unitPrice);
                        stmts.setString(4,quantity);
                        stmts.setString(5,productCategory);
                        stmts.setString(6,productDescription);

                        stmts.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Product Added");

                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                        System.out.println(e);
                    }
            }
        });

        searchProductQueryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String searchQuery = searchProductQueryInput.getText().trim();
                System.out.println(searchQuery);
            //Update_table("");

                 /////////////////////////

                try{
                    list = FXCollections.observableArrayList();

                    String query = "Select * from products where productname like '"+searchQuery+"%'";
                 //   pst = con.prepareStatement(query);
                //    pst.setString(1, searchQuery);

//            PreparedStatement stmts=con.prepareStatement(query);
//            stmts.setString(1, searchQuery );

                    ResultSet set = con.createStatement().executeQuery(query);

                    while (set.next()){

                        products product = new products();
                        product.setProductcode(set.getString("productcode"));
                        product.setProductname(set.getString("productname"));
                        product.setUnitprice(set.getDouble("unitprice"));
                        product.setQuantity(set.getDouble("quantity"));
                        product.setCategory(set.getString("category"));

                        list.add(product);

//                String check = set.getString("productname");
//                System.out.println(check);
                    }
                    productCode.setCellValueFactory(new PropertyValueFactory<>("productcode"));
                    productName.setCellValueFactory(new PropertyValueFactory<>("productname"));
                    unitPrice.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
                    stockAvailability.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                    productCategory.setCellValueFactory(new PropertyValueFactory<>("category"));



                    Callback<TableColumn<products,String>,TableCell<products,String>> cellFactory
                            =(params)-> {
                        final TableCell<products,String> cell = new TableCell<products,String>(){

                            @Override
                            public void updateItem(String item, boolean empty){
                                super.updateItem(item, empty);

                                if(empty){
                                    setGraphic(null);
                                    setText(null);
                                }else {
                                    final Button editbutton = new Button("Delete");
                                    editbutton.setOnAction(event ->{
                                                try{

                                                    int selectedIndex = table.getSelectionModel().getSelectedIndex();
                                                    String selectedItem = productCode.getText();
                                                    products product = (products) table.getSelectionModel().getSelectedItem();
                                                    String code = product.getProductcode();


                                                    String query1 = "DELETE FROM products WHERE productcode = ?";
                                                    pst = con.prepareStatement(query1);
                                                    pst.setString(1, code);
                                                    pst.executeUpdate();
                                                    table.getItems().remove(selectedIndex);



                                                }
                                                catch(Exception e){
                                                    JOptionPane.showMessageDialog(null, e);
                                                    System.out.println(e);
                                                }
                                            }

                                    );
                                    setGraphic(editbutton);
                                    setText(null);

                                }
                            }


                        };

                        return cell;
                    };

                    buttonColumn.setCellFactory(cellFactory);
                    table.setItems(list);
                }
                catch(Exception e){

                }

                /////////////////////////

            }
        });
        addProductButtonInvoice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String searchQuery = searchProductField.getText().trim();
                System.out.println(searchQuery);

                //Update_table("");

                /////////////////////////

                try{
                    list = FXCollections.observableArrayList();

                    String query = "Select * from products where productcode like '"+searchQuery+"%'";
                    //   pst = con.prepareStatement(query);
                    //    pst.setString(1, searchQuery);

//            PreparedStatement stmts=con.prepareStatement(query);
//            stmts.setString(1, searchQuery );

                    ResultSet set = con.createStatement().executeQuery(query);

                    while (set.next()){

                        products product = new products();
                        product.setProductcode(set.getString("productcode"));
                        product.setProductname(set.getString("productname"));
                        product.setUnitprice(set.getDouble("unitprice"));


                        list.add(product);

//                String check = set.getString("productname");
//                System.out.println(check);
                    }
                    invoicePcode.setCellValueFactory(new PropertyValueFactory<>("productcode"));
                    invoicePname.setCellValueFactory(new PropertyValueFactory<>("productname"));
                    invoicePunitprice.setCellValueFactory(new PropertyValueFactory<>("unitprice"));

                    invoicePquantity.setCellFactory(TextFieldTableCell.forTableColumn());


                    System.out.println(invoicePquantity);

                    Callback<TableColumn<invoice,String>,TableCell<invoice,String>> cellFactory
                            =(params)-> {
                        final TableCell<invoice,String> cell = new TableCell<invoice,String>(){

                            @Override
                            public void updateItem(String item, boolean empty){
                                super.updateItem(item, empty);

                                if(empty){
                                    setGraphic(null);
                                    setText(null);
                                }else {
                                    final Button editbutton = new Button("add");
                                    editbutton.setOnAction(event ->{
                                                try{

                                                    int selectedIndex = updateTable.getSelectionModel().getSelectedIndex();
                                                    String selectedItem = invoicePcode.getText();
                                                    products product = (products) updateTable.getSelectionModel().getSelectedItem();
                                                    String code = product.getProductcode();


                                                    String query1 = "INSERT INTO invoice (invoicePcode, invoicePname, invoicePunitprice) SELECT productcode,productname,unitprice FROM products WHERE productcode = ?";
                                                    pst = con.prepareStatement(query1);
                                                    pst.setString(1, code);
                                                    pst.executeUpdate();
                                                    String quantity = quantityinvoice.getText().trim();


                                                    String query2 = "UPDATE invoice SET invoicePquantity = '"+quantity+"' WHERE invoicePcode = ?";
                                                    pst = con.prepareStatement(query2);
                                                    pst.setString(1, code);
                                                    pst.executeUpdate();
                                                    String query3 = "UPDATE invoice SET invoicePtotal = invoicePquantity*invoicePunitprice";
                                                    pst = con.prepareStatement(query3);
                                                    pst.executeUpdate();
                                                    String billno  = billnumber.getText().trim();
                                                    String query4 = "UPDATE invoice SET billno = '"+billno+"' WHERE invoicePcode = ?";
                                                    pst = con.prepareStatement(query4);
                                                    pst.setString(1, code);
                                                    pst.executeUpdate();






                                                }
                                                catch(Exception e){
                                                    JOptionPane.showMessageDialog(null, e);
                                                    System.out.println(e);
                                                }
                                            }

                                    );
                                    setGraphic(editbutton);
                                    setText(null);

                                }
                            }


                        };

                        return cell;
                    };

                    buttonColumninvoice.setCellFactory(cellFactory);
                updateTable.setItems(list);
                }
                catch(Exception e){

                }

                /////////////////////////

            }
        });
        settingsRedirect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                productsTab.setVisible(false);
                settingsTab.setVisible(true);
                invoicesTab.setVisible(false);
                dashboardTab.setVisible(false);
            }
        });

        dashboardRedirect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                productsTab.setVisible(false);
                settingsTab.setVisible(false);
                invoicesTab.setVisible(false);
                dashboardTab.setVisible(true);
            }
        });

        productRedirect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                productsTab.setVisible(true);
                settingsTab.setVisible(false);
                invoicesTab.setVisible(false);
                dashboardTab.setVisible(false);
            }
        });

        invoiceRedirect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                productsTab.setVisible(false);
                settingsTab.setVisible(false);
                invoicesTab.setVisible(true);
                dashboardTab.setVisible(false);
            }
        });

        editProductButton.setOnAction(new EventHandler<ActionEvent>() {
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
    private void populatetableonsearch(){
        try{
    list = FXCollections.observableArrayList();

    String query = "Select * from products";
//            PreparedStatement stmts=con.prepareStatement(query);
//            stmts.setString(1, searchProductQueryInput.getText().trim() + "%" );

            ResultSet set = con.createStatement().executeQuery(query);

            while (set.next()){

                products product = new products();
                product.setProductcode(set.getString("productcode"));
                product.setProductname(set.getString("productname"));
                product.setUnitprice(set.getDouble("unitprice"));
                product.setQuantity(set.getDouble("quantity"));
                product.setCategory(set.getString("category"));

               list.add(product);


                String check = set.getString("productname");
                System.out.println(check);
            }
            productCode.setCellValueFactory(new PropertyValueFactory<>("productcode"));
            productName.setCellValueFactory(new PropertyValueFactory<>("productname"));
            unitPrice.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
            stockAvailability.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            productCategory.setCellValueFactory(new PropertyValueFactory<>("category"));



            Callback<TableColumn<products,String>,TableCell<products,String>> cellFactory
                    =(params)-> {
                final TableCell<products,String> cell = new TableCell<products,String>(){

                    @Override
                    public void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);

                        if(empty){
                            setGraphic(null);
                            setText(null);
                        }else {
                            final Button editbutton = new Button("Delete");
                            editbutton.setOnAction(event ->{
                                        try{

                                            int selectedIndex = table.getSelectionModel().getSelectedIndex();
                                            String selectedItem = productCode.getText();
                                            products product = (products) table.getSelectionModel().getSelectedItem();
                                            String code = product.getProductcode();


                                            String query1 = "DELETE FROM products WHERE productcode = ?";
                                            pst = con.prepareStatement(query1);
                                            pst.setString(1, code);
                                            pst.executeUpdate();
                                            table.getItems().remove(selectedIndex);


                                        }
                                        catch(Exception e){
                                            JOptionPane.showMessageDialog(null, e);
                                            System.out.println(e);
                                        }
                                    }

                                    );
                            setGraphic(editbutton);
                            setText(null);

                        }
                    }


                };

              return cell;
            };

            buttonColumn.setCellFactory(cellFactory);
            table.setItems(list);
        }
        catch(Exception e){

        }
    }
    Double totalAmount=0.0;
    Double cash=0.0;
    Double balance=0.0;
    Double bHeight=0.0;

    ArrayList<String> itemName = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<String> itemPrice = new ArrayList<>();
    ArrayList<String> subtotal = new ArrayList<>();





    String iname;
    Double iquantity;
    Double iprice;
    Double iamount;
    Double ibillno;

    public void jButton2ActionPerformed(ActionEvent actionEvent) {

        getData();
        bHeight = Double.valueOf(itemName.size());
        //JOptionPane.showMessageDialog(rootPane, bHeight);

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new DashboardController.BillPrintable(),getPageFormat(pj));
        try {
            pj.print();

        }
        catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }


    private void getData() {
        try {
            String billno = billnumber.getText();
            String sql="SELECT `billno`, `invoicePname`, `invoicePquantity`, `invoicePunitprice`, `invoicePtotal` FROM `invoice` WHERE billno='"+billno+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                itemName.add(rs.getString("invoicePname"));
                quantity.add(rs.getString("invoicePquantity"));
                itemPrice.add(rs.getString("invoicePunitprice"));
                subtotal.add(rs.getString("invoicePtotal"));

            }

        } catch (Exception e) {
        }
    }
    public PageFormat getPageFormat(PrinterJob pj)
    {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double bodyHeight = bHeight;
        double headerHeight = 5.0;
        double footerHeight = 5.0;
        double width = cm_to_pp(8);
        double height = cm_to_pp(headerHeight+bodyHeight+footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0,10,width,height - cm_to_pp(1));

        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);

        return pf;
    }



    protected static double cm_to_pp(double cm)
    {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch)
    {
        return inch * 72d;
    }



    public class BillPrintable implements Printable {




        public int print(Graphics graphics, PageFormat pageFormat,int pageIndex)
                throws PrinterException
        {

            int r= itemName.size();

            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {

                Graphics2D g2d = (Graphics2D) graphics;
                double width = pageFormat.getImageableWidth();
                g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY());



                //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));

                try{
                    int y=20;
                    int yShift = 10;
                    int headerRectHeight=15;
                    ImageIcon icon=new ImageIcon("E:/b.png");

                    String billno  = billnumber.getText().trim();
                    String selectSQL = "SELECT SUM(invoicePtotal) AS Totalamount FROM invoice WHERE billno='"+billno+"'";
                    PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
                    ResultSet rs = preparedStatement.executeQuery();
                    String Totalamount = rs.getString("Totalamount");
                    // int headerRectHeighta=40;


                    g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
                    g2d.drawImage(icon.getImage(), 50, 20, 90, 30,null );y+=yShift+30;
                    g2d.drawString("-------------------------------------",12,y);y+=yShift;
                    g2d.drawString("         FUCK.com        ",12,y);y+=yShift;
                    g2d.drawString("   No 00000 Address Line One ",12,y);y+=yShift;
                    g2d.drawString("   FUCK Line 02 SRI LANKA ",12,y);y+=yShift;
                    g2d.drawString("   www.facebook.com/BLENDSTUDIOS ",12,y);y+=yShift;
                    g2d.drawString("        +FUCK YOU      ",12,y);y+=yShift;
                    g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;

                    g2d.drawString(" Item Name                  Price   ",10,y);y+=yShift;
                    g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;

                    for(int s=0; s<r; s++)
                    {
                        g2d.drawString(" "+itemName.get(s)+"                            ",10,y);y+=yShift;
                        g2d.drawString("      "+quantity.get(s)+" * "+itemPrice.get(s),10,y); g2d.drawString(subtotal.get(s),160,y);y+=yShift;

                    }
                    g2d.drawString("-------------------------------------",10,y);y+=yShift;
                    g2d.drawString(" Total amount:               "+Totalamount+"   ",10,y);y+=yShift;
                    g2d.drawString("-------------------------------------",10,y);y+=yShift;

                    g2d.drawString("*************************************",10,y);y+=yShift;
                    g2d.drawString("       FUCK YOU  AND FUCK YOU ALL          ",10,y);y+=yShift;
                    g2d.drawString("*************************************",10,y);y+=yShift;
                    g2d.drawString("       SOFTWARE BY:BLEND STUDIOS          ",10,y);y+=yShift;
                    g2d.drawString("   CONTACT: FUCK@FUCK.com       ",10,y);y+=yShift;


                }
                catch(Exception e){
                    e.printStackTrace();
                }

                result = PAGE_EXISTS;
            }
            return result;
        }
    }
}

//    private void invoiceadd(){
//        try{
//            list = FXCollections.observableArrayList();
//
//            String query = "Select * from invoice";
////            PreparedStatement stmts=con.prepareStatement(query);
////            stmts.setString(1, searchProductQueryInput.getText().trim() + "%" );
//
//            ResultSet set = con.createStatement().executeQuery(query);
//
//            while (set.next()){
//
//                products invoice = new invoice();
//                invoice.setinvoicePcode(set.getString("invoicePcode"));
//                invoice.setinvoicePname(set.getString("roductname"));
//                invoice.setPrice(set.getString("unitprice"));
//                invoice.setStockavailable(set.getString("quantity"));
//                invoice.setCategory(set.getString("category"));
//
//                list.add(product);
//
//
//                String check = set.getString("productname");
//                System.out.println(check);
//            }
//            productCode.setCellValueFactory(new PropertyValueFactory<>("productcode"));
//            productName.setCellValueFactory(new PropertyValueFactory<>("productname"));
//            unitPrice.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
//            stockAvailability.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//            productCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
//
//
//
//            Callback<TableColumn<products,String>,TableCell<products,String>> cellFactory
//                    =(params)-> {
//                final TableCell<products,String> cell = new TableCell<products,String>(){
//
//                    @Override
//                    public void updateItem(String item, boolean empty){
//                        super.updateItem(item, empty);
//
//                        if(empty){
//                            setGraphic(null);
//                            setText(null);
//                        }else {
//                            final Button editbutton = new Button("Delete");
//                            editbutton.setOnAction(event ->{
//                                        try{
//
//                                            int selectedIndex = table.getSelectionModel().getSelectedIndex();
//                                            String selectedItem = productCode.getText();
//                                            products product = (products) table.getSelectionModel().getSelectedItem();
//                                            String code = product.getProductcode();
//
//
//                                            String query1 = "DELETE FROM products WHERE productcode = ?";
//                                            pst = con.prepareStatement(query1);
//                                            pst.setString(1, code);
//                                            pst.executeUpdate();
//                                            table.getItems().remove(selectedIndex);
//
//
//                                        }
//                                        catch(Exception e){
//                                            JOptionPane.showMessageDialog(null, e);
//                                            System.out.println(e);
//                                        }
//                                    }
//
//                            );
//                            setGraphic(editbutton);
//                            setText(null);
//
//                        }
//                    }
//
//
//                };
//
//                return cell;
//            };
//
//            buttonColumn.setCellFactory(cellFactory);
//            table.setItems(list);
//        }
//        catch(Exception e){
//
//        }
//    }
//    public void deleteItem(){
//        int selectedIndex = table.getSelectionModel().getSelectedIndex();
//        String selectedItem = productCode.getText();
//        if(selectedIndex >= 0){
//
//            String query1 = "DELETE FROM products WHERE productcode = ?";
//            pst = con.prepareStatement(query1);
//            pst.setString(1, selectedItem);
//            pst.executeQuery();
//            table.getItems().remove(selectedIndex);
//        } else {
//            System.out.println("something went wrong");
//        }
//    }


