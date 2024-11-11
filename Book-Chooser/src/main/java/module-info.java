module com.example.bookchooser {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    exports Classes to com.fasterxml.jackson.databind;

    opens Model;
    opens Controller;
    opens Classes to com.fasterxml.jackson.databind;
}