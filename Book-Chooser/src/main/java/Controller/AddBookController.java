package Controller;

import Classes.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;


public class AddBookController extends MenuController{
    @FXML
    Text titleText;

    @FXML
    Text authorText;

    public void buttClick() {
        if(titleText != null && authorText != null ){
            Book book = new Book(titleText.getText(),authorText.getText());
        }
    }
}
