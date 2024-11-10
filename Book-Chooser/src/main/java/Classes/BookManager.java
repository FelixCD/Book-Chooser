package Classes;

import Classes.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static List<Book> bookList;
    private static ObjectMapper objectMapper;  // Jackson's main class for reading and writing JSON
    private static final String fileName = "books.json";  // The name of the file where books will be saved

    static {
        bookList = new ArrayList<>();  // Initialize the static bookList
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
                // Read the JSON file and convert it to a List of Book objects
                bookList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getBooks() {
        return bookList;
    }
}
