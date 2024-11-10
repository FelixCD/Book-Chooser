package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    static Stage mainStage;

    public static void start(Stage stage){
        mainStage = stage; //show stage
        mainStage.show();
    }
    public static void loadScene(String file) throws IOException { //to load most menus
        FXMLLoader loader = new FXMLLoader(MenuController.class.getResource(file));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        mainStage.setScene(new Scene(root,870,560));
        mainStage.show();
        start(mainStage);
    }

    public void mainPressed() throws IOException {
        loadScene("/fxml/MainMenu.fxml"); //all menus but one load main menu
    }


}
