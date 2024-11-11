package Controller;

import Model.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController extends MenuController{

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    AnchorPane anchorPane;

    public void initialize() {
        if (anchorPane != null) {
            double width = anchorPane.prefWidth(-1);
            double height = anchorPane.prefHeight(-1);

            // Set the stage size to the size of the AnchorPane
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.setWidth(width);
            stage.setHeight(height);
        }
    }

    public void addClick() throws IOException {
    }

    public void chooseClick() throws IOException{
        loadScene("/fxml/ToolPages/choose-book.fxml");
    }

    public void removPress() throws IOException {
    }
}