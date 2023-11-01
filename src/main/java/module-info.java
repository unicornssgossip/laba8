module com.example.laba8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laba8 to javafx.fxml;
    exports com.example.laba8;
}