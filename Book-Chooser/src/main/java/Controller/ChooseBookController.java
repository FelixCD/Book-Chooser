package Controller;

import Classes.Book;
import Classes.BookManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ChooseBookController extends MenuController{
    @FXML
    private ListView<Book> bookListView;
    @FXML
    Text bookName;
    List<Book> books;
    private ChooseBookController chooseBookController;

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

    @FXML
    private void deleteSelectedBook() {
        Book selectedBook = bookListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            // Remove the book from the ListView
            bookListView.getItems().remove(selectedBook);
            // Remove the book from the BookManager's list and update the file
            BookManager.deleteBook(selectedBook);
        }
    }
    @FXML
    private void addBook() throws IOException {
        Stage popupStage = new Stage();

        FXMLLoader loader = new FXMLLoader(MenuController.class.getResource("/fxml/ToolPages/add-book.fxml"));
        Parent root = loader.load();

        AddBookController addBookController = loader.getController();
        addBookController.setPopupStage(popupStage);
        addBookController.setChooseBookController(this);

        popupStage.setScene(new Scene(root));

        popupStage.show();
        refreshListView();
    }

    public void refreshListView() {
        books = BookManager.getBooks();
        bookListView.getItems().setAll(books);
    }

}
