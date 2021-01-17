package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class products {
    private  SimpleStringProperty productID;
    private  SimpleStringProperty productName;
    private  SimpleDoubleProperty unitPrice;
    private  SimpleDoubleProperty quantity;
    private  SimpleStringProperty category;
    private  SimpleDoubleProperty total;

    public products(String productID, String productName, Double unitPrice, Double quantity, String category, Double total){
        this.productID = new SimpleStringProperty(productID);
        this.productName = new SimpleStringProperty(productName);
        this.unitPrice = new SimpleDoubleProperty(unitPrice);
        this.quantity = new SimpleDoubleProperty(quantity);
        this.category = new SimpleStringProperty(category);
        this.total = new SimpleDoubleProperty(total);
    }


    public String getProductID() {
        return productID.get();
    }

    public SimpleStringProperty productIDProperty() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID.set(productID);
    }

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public double getUnitPrice() {
        return unitPrice.get();
    }

    public SimpleDoubleProperty unitPriceProperty() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice.set(unitPrice);
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

    public Double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(Double total) {
        this.total.set(total);
    }
}
