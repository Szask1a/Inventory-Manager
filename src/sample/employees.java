package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class employees {
    private SimpleStringProperty empID;
    private  SimpleStringProperty empName;
    private SimpleStringProperty position;
    private  SimpleDoubleProperty salary;
    private  SimpleStringProperty branch;
    private  SimpleStringProperty shift;

    public employees(String empID, String empName, String  position, Double salary, String branch, String  shift){
        this.empID = new SimpleStringProperty(empID);
        this.empName = new SimpleStringProperty(empName);
        this.position = new SimpleStringProperty(position);
        this.salary = new SimpleDoubleProperty(salary);
        this.branch = new SimpleStringProperty(branch);
        this.shift = new SimpleStringProperty(shift);
    }


    public String getEmpID() {
        return empID.get();
    }

    public SimpleStringProperty empIDProperty() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID.set(empID);
    }

    public String getEmpName() {
        return empName.get();
    }

    public SimpleStringProperty empNameProperty() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName.set(empName);
    }

    public double getSalary() {
        return salary.get();
    }

    public SimpleDoubleProperty salaryProperty() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }

    public String  getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public String getBranch() {
        return branch.get();
    }

    public SimpleStringProperty branchProperty() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch.set(branch);
    }

    public String getShift() {
        return shift.get();
    }

    public SimpleStringProperty shiftProperty() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift.set(shift);
    }
}
