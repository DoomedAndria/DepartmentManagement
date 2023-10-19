package com.example.ragac;

import com.example.ragac.models.Department;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class AddDepartmentFormController {
    @FXML
    private TextField depName;
    @FXML
    private Label message;

    private Stage stage;
    public callable refresh;
    public String formType = "add";
    public Department ref;


    public void setStage(Stage stage){
        this.stage = stage;
    }
    public void setDepName(String s){
        depName.setText(s);
    }

    public void submit(ActionEvent e){
        if(Objects.equals(depName.getText(), "")){
            message.setText("department name can not be blank");
        }
        else {
            if(Objects.equals(formType, "add")){
                Data.departments.add(new Department(depName.getText(),new ArrayList<>()));
                refresh.call();
                stage.close();
            } else if (Objects.equals(formType, "edit")) {
                for (Department d: Data.departments){
                    if(d==ref){
                        d.setName(depName.getText());
                        refresh.call();
                        stage.close();
                    }
                }
            }
        }
    }

}
