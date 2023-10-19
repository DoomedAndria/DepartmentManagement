module com.example.ragac {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens com.example.ragac to javafx.fxml;
    exports com.example.ragac;
}