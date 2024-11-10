package Controller;

import Classes.Book;
import Classes.BookManager;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Random;

public class ChooseBookController extends MenuController{
    @FXML
    private ListView<Book> bookListView;
    @FXML
    Text bookName;
    List<Book> books;

    public void initialize() {
        BookManager.loadBooksFromFile();
        books = BookManager.getBooks();

        bookListView.setCellFactory(param -> new ListCell<Book>() {
            @Override
            protected void updateItem(Book book, boolean empty) {
                super.updateItem(book, empty);
                if (empty || book == null) {
                    setText(null);
                } else {
                    setText(book.getTitle() + " by " + book.getAuthor());
                }
            }
        });

        // Add books to the ListView
        bookListView.getItems().setAll(books);
    }

    public void randPressed(){
        Random rand = new Random();
        int randomInt = rand.nextInt(((books.size()-1) - 0) + 1);

        bookName.setText("Book Chosen: " + books.get(randomInt).getTitle());
    }
}
