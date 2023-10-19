package com.example.ragac;

import com.example.ragac.models.Department;
import com.example.ragac.models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.text.Text;


public class DepartmentComponentController {
    @FXML
    private Label depName;
    @FXML
    private Text memberCount;
    public callable refreshDetailedView;


    private Department ref;
    public void clc(ActionEvent e){
        refreshDetailedView.call(ref);
    }

    public void setDepartment(Department dep){
        ref = dep;
        depName.setText(ref.getName());
        memberCount.setText(Integer.toString(ref.getMembers().size()));
    }
}
