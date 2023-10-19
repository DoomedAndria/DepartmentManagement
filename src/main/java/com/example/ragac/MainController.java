package com.example.ragac;

import com.example.ragac.models.Department;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    private VBox deps;
    @FXML
    private Pane depDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDepartments();
        loadDepartmentDetails(Data.departments.get(0));
    }

    public void loadDepartmentDetails(Department department) {
        depDetails.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DepartmentDetails.fxml"));


        Parent dd ;
        try {
            dd = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DepartmentDetailsController controller = loader.getController();
        controller.parent = this;
        controller.setDepartment(department);
        depDetails.getChildren().add(dd);
    }

    public void loadDepartments(){
        deps.getChildren().clear();

        for (Department d : Data.departments) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DepartmentComponent.fxml"));
            Parent department;
            try {
                department = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            DepartmentComponentController controller = loader.getController();
            controller.setDepartment(d);
            controller.refreshDetailedView = new callable() {
                @Override
                public void call() {
                }
                @Override
                public void call(Department department) {
                    loadDepartmentDetails(d);
                }
            };

            deps.getChildren().add(department);
        }
    }

    public void openNewWindow(ActionEvent e) throws IOException {
        FXMLLoader formLoader = new FXMLLoader(getClass().getResource("AddDepartmentForm.fxml"));
        Parent form = formLoader.load();
        AddDepartmentFormController controller = formLoader.getController();

        Stage secondaryStage = new Stage();
        controller.setStage(secondaryStage);
        controller.formType = "add";
        controller.refresh = new callable() {
            @Override
            public void call() {
                loadDepartments();
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
