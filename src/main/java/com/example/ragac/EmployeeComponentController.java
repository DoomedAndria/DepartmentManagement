package com.example.ragac;

import com.example.ragac.models.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EmployeeComponentController {
    private Employee ref;
    @FXML
    private Label name;
    @FXML
    private Label lastName;

    public void setEmployee(Employee employee){
        ref = employee;
        name.setText(ref.getName());
        lastName.setText(ref.getLastName());
    }

    public void details(){

    }
}
