package Classes;

import Classes.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static ObservableList<Book> bookList;
    private static ObjectMapper objectMapper;  // Jackson's main class for reading and writing JSON
    private static final String fileName = "books.json";  // The name of the file where books will be saved

    static {
        bookList =  FXCollections.observableArrayList();  // Initialize the static bookList
        objectMapper = new ObjectMapper();  // Initialize the ObjectMapper
    }

    public static void addBook(Book book) {
        bookList.add(book);  // Add book to the list
        saveBooksToFile();  // Save the updated list to a file
    }

    private static void saveBooksToFile() {
        try {
            objectMapper.writeValue(new File(fileName), bookList);  // Write the list of books to a file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadBooksFromFile() {
        try {
            File file = new File(fileName);
            if (file.exists()) {  // Check if the file exists
                List<Book> books = objectMapper.readValue(file, objectMapper.getTypeFactory()
                        .constructCollectionType(List.class, Book.class));
                bookList.setAll(books);  // Update bookList with the loaded books
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getBooks() {
        return bookList;
    }

    public static void deleteBook(Book book) {
        bookList.remove(book);  // Remove the selected book from the list
        saveBooksToFile();  // Save the updated list to the file
    }
}
