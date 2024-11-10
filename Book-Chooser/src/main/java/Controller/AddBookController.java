package Controller;

import Classes.Book;
import Classes.BookManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AddBookController extends MenuController{
    @FXML
    TextField titleText;

    @FXML
    TextField authorText;

    public void buttClick() {
        if(titleText != null && authorText != null ){
            Book book = new Book(titleText.getText(),authorText.getText());
            BookManager.addBook(book);
        }

        titleText.setText("");
        authorText.setText("");

    }
}
