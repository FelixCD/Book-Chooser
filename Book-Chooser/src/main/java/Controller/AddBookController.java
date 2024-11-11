package Controller;

import Classes.Book;
import Classes.BookManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookController extends MenuController{
    @FXML
    TextField titleText;

    @FXML
    TextField authorText;

    private Stage popupStage; // Stage reference for the popup window

    private ChooseBookController chooseBookController;


    // Setter method to pass the Stage reference
    public void setPopupStage(Stage popupStage) {
        this.popupStage = popupStage;
    }

    public void setChooseBookController(ChooseBookController chooseBookController) {
        this.chooseBookController = chooseBookController;
    }

    public void buttClick() {
        if(titleText != null && authorText != null ){
            Book book = new Book(titleText.getText(),authorText.getText());
            BookManager.addBook(book);
        }

        titleText.setText("");
        authorText.setText("");
        if(popupStage != null){
            popupStage.close();
        }
        if (chooseBookController != null) {
            chooseBookController.refreshListView();  // Refresh the ListView in ChooseBookController
        }
    }
}
