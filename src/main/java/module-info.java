module com.example.ogarkovbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ogarkovbook to javafx.fxml;
    exports com.example.ogarkovbook;
}