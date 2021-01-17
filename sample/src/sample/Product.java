package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
private final StringProperty productcode = new SimpleStringProperty();
private final StringProperty productname = new SimpleStringProperty();
private final DoubleProperty unitprice = new SimpleDoubleProperty();
private final DoubleProperty quantity = new SimpleDoubleProperty();
private final StringProperty category = new SimpleStringProperty();

public String getProductcode(){
    return productcode.get();
}
public void setProductcode(String value){
    productcode.set(value);
}
public StringProperty productcodeProperty(){
    return productcode;
}
    public String getProductname(){
        return productname.get();
    }
    public void setProductname(String value){
        productname.set(value);
    }
    public StringProperty productnameProperty(){
        return productname;
    }

    public Double getUnitprice(){
        return unitprice.get();
    }
    public void setUnitprice(double value){
        unitprice.set(value);
    }
    public DoubleProperty unitpriceProperty(){
        return unitprice;
    }
    public Double getQuantity(){
        return quantity.get();
    }
    public void setQuantity(double value){
        quantity.set(value);
    }
    public DoubleProperty quantityProperty(){
        return quantity;
    }

    public String getCategory(){
        return category.get();
    }
    public void setCategory(String value){
        category.set(value);
    }
    public StringProperty categoryProperty(){
        return category;
    }

}
