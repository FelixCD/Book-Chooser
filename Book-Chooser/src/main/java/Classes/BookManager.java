package Classes;

import Classes.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;
    private final ObjectMapper objectMapper;  // Jackson's main class for reading and writing JSON
    private final String fileName = "books.json";  // The name of the file where books will be saved

    public BookManager() {
        bookList = new ArrayList<>();
        objectMapper = new ObjectMapper();  // Instantiate the ObjectMapper
    }

    // Method to add a new book
    public void addBook(Book book) {
        bookList.add(book);  // Add book to the list
        saveBooksToFile();  // Save the updated list to a file
    }

    // Method to save the books list to a JSON file
    private void saveBooksToFile() {
        try {
            objectMapper.writeValue(new File(fileName), bookList);  // Write the list of books to a file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load books from the JSON file
    public void loadBooksFromFile() {
        try {
            File file = new File(fileName);
            if (file.exists()) {  // Check if the file exists
                // Read the JSON file and convert it to a List of Book objects
                bookList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the list of books
    public List<Book> getBooks() {
        return bookList;
    }
}
