package com.example.ragac;

import com.example.ragac.models.Department;
import com.example.ragac.models.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;



public class DepartmentDetailsController{
    private Department ref;
    @FXML
    private Label depName;
    @FXML
    private Label emCount;
    @FXML
    private VBox employees;
    public MainController parent;


    public void setDepartment(Department department){
        ref = department;
        depName.setText(ref.getName());
        emCount.setText(Integer.toString(ref.getMembers().size()));
        loadEmployees();
    }

    public void loadEmployees(){
        employees.getChildren().clear();

        for(Employee employee : ref.getMembers()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeComponent.fxml"));

            Parent emp;
            try {
                emp = loader.load();
            } catch (IOException e){
                throw new RuntimeException(e);
            }

            EmployeeComponentController controller = loader.getController();
            controller.setEmployee(employee);
            employees.getChildren().add(emp);
        }

    }

    public void editDepartment() throws IOException {
        FXMLLoader formLoader = new FXMLLoader(getClass().getResource("AddDepartmentForm.fxml"));
        Parent form = formLoader.load();
        AddDepartmentFormController controller = formLoader.getController();
        controller.formType = "edit";
        controller.ref = ref;

        Stage secondaryStage = new Stage();
        controller.setStage(secondaryStage);
        controller.setDepName(ref.getName());
        controller.refresh = new callable() {
            @Override
            public void call() {
                parent.loadDepartments();
            }
            @Override
            public void call(Department department) {
            }
        };

        Scene scene = new Scene(form);

        secondaryStage.setScene(scene);
        secondaryStage.show();
    }
}
