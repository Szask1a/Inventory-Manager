package sample;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.sql.*;

import java.sql.Statement;

public class DBConnect {

    public static Connection ConnectDB(){
        try{
            String url="jdbc:sqlite:E:\\github\\Billing-System-by-BLEND-STUDIOS\\Billing-System-by-BLEND-STUDIOS\\BillingDatabase.db";
            Connection con = DriverManager.getConnection(url);

            System.out.println("Database Connected");
            return con;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Connection Failed");
            return null;
        }
    }


}
