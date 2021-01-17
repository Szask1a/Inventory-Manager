package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class products {
    final private  SimpleStringProperty productcode = new SimpleStringProperty();
    final private  SimpleStringProperty productname = new SimpleStringProperty();
    final private  SimpleDoubleProperty unitprice   = new SimpleDoubleProperty();
    final private  SimpleDoubleProperty quantity    = new SimpleDoubleProperty();
    final private  SimpleStringProperty category    = new SimpleStringProperty();

//    products(String productcode, String productname, Double price, Double stockavailable, String category){
//        this.productcode = new SimpleStringProperty(productcode);
//        this.productname = new SimpleStringProperty(productname);
//        this.price = new SimpleDoubleProperty(price);
//        this.stockavailable = new SimpleDoubleProperty(stockavailable);
//        this.category = new SimpleStringProperty(category);
//
//    }


    public String getProductcode() {
        return productcode.get();
    }

    public SimpleStringProperty productcodeProperty() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode.set(productcode);
    }

    public String getProductname() {
        return productname.get();
    }

    public SimpleStringProperty productnameProperty() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname.set(productname);
    }

    public double getUnitprice() {
        return unitprice.get();
    }

    public SimpleDoubleProperty unitpriceProperty() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice.set(unitprice);
    }

    public double getQuantity() {
        return quantity.get();
    }

    public SimpleDoubleProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity.set(quantity);
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }
}
